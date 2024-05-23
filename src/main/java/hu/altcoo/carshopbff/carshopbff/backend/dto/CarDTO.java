package hu.altcoo.carshopbff.carshopbff.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarDTO {

    private CarTypeDTO carType;
    private String carName;

}
