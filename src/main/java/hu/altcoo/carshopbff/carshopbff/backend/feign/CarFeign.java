package hu.altcoo.carshopbff.carshopbff.backend.feign;

import feign.HeaderMap;
import feign.RequestLine;

import hu.altcoo.carshopbff.carshopbff.backend.config.ClientConfig;
import hu.altcoo.carshopbff.carshopbff.backend.dto.CarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@FeignClient(value = "car-client", url = "${backend.url}", configuration = ClientConfig.class)
public interface CarFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/car")
    List<CarDTO> findAll(@RequestHeader Map<String, Object> headerMap);
}
