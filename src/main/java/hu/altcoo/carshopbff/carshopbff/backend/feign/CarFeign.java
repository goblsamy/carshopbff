package hu.altcoo.carshopbff.carshopbff.backend.feign;

import feign.HeaderMap;
import feign.RequestLine;

import hu.altcoo.carshopbff.carshopbff.backend.config.ClientConfig;
import hu.altcoo.carshopbff.carshopbff.backend.dto.CarCreateCommandDTO;
import hu.altcoo.carshopbff.carshopbff.backend.dto.CarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(value = "car-client", url = "${backend.url}", configuration = ClientConfig.class)
public interface CarFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/car")
    List<CarDTO> findAll(@RequestHeader Map<String, Object> headerMap);

    @RequestMapping(method = RequestMethod.POST, value = "/car")
    CarDTO create(@RequestHeader Map<String, Object> headerMap, @RequestBody CarCreateCommandDTO carCreateCommandDTO);
}
