package hu.altcoo.carshopbff.carshopbff.backend.feign;

import com.vaadin.flow.spring.annotation.SpringComponent;
import org.apache.catalina.security.SecurityUtil;

import java.util.HashMap;
import java.util.Map;

@SpringComponent
public class FeignHeadersFactory {

    public Map<String, Object> build() {
        // User currentUser = SecurityUtils.currentUser();
        Map<String, Object> headerMap = new HashMap<>();

        headerMap.put("Content-Type", "application/json");
        headerMap.put("Accept", "application/json");
        headerMap.put("Accept-Encoding", "gzip, deflate");
        headerMap.put("Accept-Language", "hu-HU");

        /*
        if (currentUser != null) {
            headers.put("Authorization", currentUser.getJwtToken());
        }
         */
        return headerMap;
    }
}

