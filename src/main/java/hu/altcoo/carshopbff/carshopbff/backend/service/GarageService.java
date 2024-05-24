package hu.altcoo.carshopbff.carshopbff.backend.service;


import hu.altcoo.carshopbff.carshopbff.backend.dto.GarageDTO;
import hu.altcoo.carshopbff.carshopbff.backend.feign.FeignHeadersFactory;
import hu.altcoo.carshopbff.carshopbff.backend.feign.GarageFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageService {

    @Autowired
    private GarageFeign feign;

    @Autowired
    private FeignHeadersFactory headersFactory;


    public List<GarageDTO> findAll() {
        return feign.findAll((headersFactory.build()));
    }
}
