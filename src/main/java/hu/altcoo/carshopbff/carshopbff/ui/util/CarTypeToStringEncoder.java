package hu.altcoo.carshopbff.carshopbff.ui.util;

import com.vaadin.flow.templatemodel.ModelEncoder;
import hu.altcoo.carshopbff.carshopbff.backend.dto.CarTypeDTO;

public class CarTypeToStringEncoder implements ModelEncoder<CarTypeDTO, String> {
    @Override
    public String encode(CarTypeDTO value) {
        return value == null ? null : value.name();
    }

    @Override
    public CarTypeDTO decode(String value) {
        return value == null ? null : CarTypeDTO.valueOf(value);
    }
}
