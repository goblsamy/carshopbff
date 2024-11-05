package hu.altcoo.carshopbff.carshopbff.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarCreateCommandDTO {
    @NotNull
    private CarTypeDTO carType;

    @NotBlank(message = "Name cannot be blank.")
    private String carName;

    @NotNull(message = "Cannot be null.")
    private Integer garageId;

}
