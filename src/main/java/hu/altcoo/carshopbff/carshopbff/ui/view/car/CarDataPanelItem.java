package hu.altcoo.carshopbff.carshopbff.ui.view.car;
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
