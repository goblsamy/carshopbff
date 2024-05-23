package hu.altcoo.carshopbff.carshopbff.backend.service;

import hu.altcoo.carshopbff.carshopbff.backend.dto.CarDTO;
import hu.altcoo.carshopbff.carshopbff.backend.feign.CarFeign;
import hu.altcoo.carshopbff.carshopbff.backend.feign.FeignHeadersFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarFeign feign;

    @Autowired
    private FeignHeadersFactory headersFactory;


    public List<CarDTO> findAll() {
        return feign.findAll((headersFactory.build()));
    }
}
