package hu.altcoo.carshopbff.carshopbff.backend.feign;

import feign.HeaderMap;
import feign.RequestLine;
import hu.altcoo.carshopbff.carshopbff.backend.config.ClientConfig;
import hu.altcoo.carshopbff.carshopbff.backend.dto.GarageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@FeignClient(value = "garage-client", url = "${backend.url}", configuration = ClientConfig.class)
public interface GarageFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/garage")
    List<GarageDTO> findAll(@HeaderMap Map<String, Object> headerMap);
}
