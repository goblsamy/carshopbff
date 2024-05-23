package hu.altcoo.carshopbff.carshopbff.backend.feign;

import feign.HeaderMap;
import feign.RequestLine;
import hu.altcoo.carshopbff.carshopbff.backend.dto.GarageDTO;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;
import java.util.Map;

@FeignClient(value = "garage-client", url = "${backend.url}")
public interface GarageFeign {

    @RequestLine("GET /garage")
    List<GarageDTO> findAll(@HeaderMap Map<String, Object> headerMap);
}
