package hu.altcoo.carshopbff.carshopbff.ui.view.car;


import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.templatemodel.TemplateModel;
import hu.altcoo.carshopbff.carshopbff.backend.service.CarService;
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

    @Id("button")
    private Button button;

    @PostConstruct
    void init() {

        button.addClickListener(e -> carGrid.refresh());

        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        button.addClickShortcut(Key.ENTER);

    }


}
