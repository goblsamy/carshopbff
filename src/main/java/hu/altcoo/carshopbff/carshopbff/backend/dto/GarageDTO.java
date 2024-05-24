package hu.altcoo.carshopbff.carshopbff.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GarageDTO {

    private Integer garageCapacity;
    private String garageName;
    private List<CarDTO> cars;
}
