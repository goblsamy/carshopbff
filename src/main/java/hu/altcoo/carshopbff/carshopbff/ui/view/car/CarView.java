package hu.altcoo.carshopbff.carshopbff.ui.view.car;


import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.templatemodel.TemplateModel;
import hu.altcoo.carshopbff.carshopbff.backend.dto.CarCreateCommandDTO;
import hu.altcoo.carshopbff.carshopbff.backend.dto.CarDTO;
import hu.altcoo.carshopbff.carshopbff.backend.service.CarService;
import hu.altcoo.carshopbff.carshopbff.ui.events.DataPanelEvents;
import hu.altcoo.carshopbff.carshopbff.ui.util.CarShopConst;
import hu.altcoo.carshopbff.carshopbff.ui.view.MainView;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@Tag("car-view")
@JsModule("./src/views/car-view.js")
@Route(value = CarShopConst.ROUTE_CAR, layout = MainView.class)
@SpringComponent
@UIScope
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class CarView extends PolymerTemplate<TemplateModel> {

    @Autowired
    private CarService service;

    @Id("carGrid")
    private CarGrid carGrid;

    @Id("refreshButton")
    private Button refreshButton;

    @Id("createButton")
    private Button createButton;

    @Id("deleteButton")
    private Button deleteButton;

    @Id("editButton")
    private Button editButton;

    private CarCreateCommandDTO dtoToEdit;

    CarDataPanel dataPanel = new CarDataPanel();

    @Id("dialog")
    private Dialog dialog;

    @PostConstruct
    void init() {

        refreshButton.addClickListener(e -> carGrid.refresh());

        refreshButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        refreshButton.addClickShortcut(Key.ENTER);

        createButton.addClickListener(e -> create());

        dialog.add(dataPanel);

        dataPanel.setListener(new DataPanelEvents() {
            @Override
            public void onSave() {
                service.create(dataPanel.getCar());
                dialog.close();
                carGrid.refresh();

                CarDTO dto = new CarDTO();
                dto.setCarType(dataPanel.getCar().getCarType());
                dto.setCarName(dataPanel.getCar().getCarName());
                carGrid.grid.select(dto);
            }

            @Override
            public void onCancel() {
                dialog.close();
            }
        });
    }

    public void create(){
        dtoToEdit = new CarCreateCommandDTO();
        dataPanel.display(dtoToEdit);
        dialog.open();
        carGrid.refresh();
    }

}
