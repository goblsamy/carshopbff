package hu.altcoo.carshopbff.carshopbff.ui.view.car;
import com.vaadin.flow.templatemodel.Encode;
import com.vaadin.flow.templatemodel.ModelEncoder;
import hu.altcoo.carshopbff.carshopbff.backend.dto.CarTypeDTO;
import hu.altcoo.carshopbff.carshopbff.ui.util.CarTypeToStringEncoder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDataPanelItem {
    private String carType;
    private String carName;
    private String garageId;
}
