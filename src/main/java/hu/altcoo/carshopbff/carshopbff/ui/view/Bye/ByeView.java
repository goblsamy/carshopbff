package hu.altcoo.carshopbff.carshopbff.ui.view.Bye;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.templatemodel.TemplateModel;
import hu.altcoo.carshopbff.carshopbff.backend.service.ByeService;
import hu.altcoo.carshopbff.carshopbff.ui.util.CarShopConst;
import hu.altcoo.carshopbff.carshopbff.ui.view.MainView;
import org.springframework.beans.factory.annotation.Autowired;


@Tag("bye-view")
@JsModule("./src/views/bye-view.js")
@Route(value = CarShopConst.ROUTE_BYE, layout = MainView.class)
@SpringComponent
@UIScope
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class ByeView extends PolymerTemplate<TemplateModel> {
    @Autowired
    private ByeService service;

    @Id("textField")
    private TextField textField;

    @Id("button")
    private Button button;

    public ByeView () {
        button.addClickListener(e -> Notification.show(service.greet(textField.getValue())));

        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        button.addClickShortcut(Key.ENTER);
    }


}
