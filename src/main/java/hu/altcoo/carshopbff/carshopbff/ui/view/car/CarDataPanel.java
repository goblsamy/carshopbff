package hu.altcoo.carshopbff.carshopbff.ui.view.car;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.templatemodel.TemplateModel;
import hu.altcoo.carshopbff.carshopbff.backend.dto.CarCreateCommandDTO;
import hu.altcoo.carshopbff.carshopbff.backend.dto.CarTypeDTO;
import hu.altcoo.carshopbff.carshopbff.ui.events.DataPanelEvents;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Tag("car-data-panel")
@JsModule("./src/views/car-data-panel.js")
@SpringComponent
@Scope("prototype")
public class CarDataPanel extends PolymerTemplate<CarDataPanel.Model> {

    @Id("cancel")
    private Button cancel;

    @Id("save")
    private Button save;

    @Id("comboCarType")
    ComboBox<String> comboCarType;

    private DataPanelEvents listener;

    public void setListener(DataPanelEvents listener) {
        this.listener = listener;
    }

    @PostConstruct
    void init() {
        cancel.addClickListener(e -> listener.onCancel());
        save.addClickListener(e -> listener.onSave());

        comboCarType.setItems(getCarTypeNames());
        comboCarType.setItemLabelGenerator(
                e -> e
        );
        comboCarType.setPreventInvalidInput(true);
    }

    public CarCreateCommandDTO getCar() {
        CarDataPanelItem item = getModel().getItem();

        String carTypeName = comboCarType.getValue();
        CarTypeDTO carType = carTypeName != null ? CarTypeDTO.valueOf(carTypeName) : null;
        Integer garageId = StringUtils.isBlank(item.getGarageId()) ? null : Integer.parseInt(item.getGarageId());

        return new CarCreateCommandDTO(carType, item.getCarName(), garageId);
    }

    public void display(CarCreateCommandDTO dto) {
        getModel().setItem(new CarDataPanelItem(
                dto.getCarType() == null ? null : dto.getCarType().name(), // Itt történik az enum Stringgé konvertálása
                dto.getCarName(),
                dto.getGarageId() == null ? "" : dto.getGarageId().toString()
        ));
    }


    public static List<String> getCarTypeNames() {
        return Arrays.stream(CarTypeDTO.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    public interface Model extends TemplateModel {

        CarDataPanelItem getItem();

        void setItem(CarDataPanelItem item);
    }
}
