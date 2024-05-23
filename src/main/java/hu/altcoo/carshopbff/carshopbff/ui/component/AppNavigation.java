package hu.altcoo.carshopbff.carshopbff.ui.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.templatemodel.TemplateModel;
import hu.altcoo.carshopbff.carshopbff.ui.util.CarShopConst;
import hu.altcoo.carshopbff.carshopbff.ui.view.Bye.ByeView;
import hu.altcoo.carshopbff.carshopbff.ui.view.Hello.HelloView;
import hu.altcoo.carshopbff.carshopbff.ui.view.car.CarView;

import java.util.ArrayList;
import java.util.List;

@Tag("app-navigation")
@JsModule("./src/component/app-navigation.js")
@SpringComponent
@UIScope
public class AppNavigation extends PolymerTemplate<TemplateModel> implements AfterNavigationObserver {

    @Id("menu")
    private Tabs menu;

    private List<String> hrefs = new ArrayList<>();

    public AppNavigation() {
        createMenuTabs();
    }

    private void createMenuTabs() {
        menu.setOrientation(Tabs.Orientation.HORIZONTAL);

        // menu.add(createTab(VaadinIcon.DISC, "Hello", HelloView.class));
        // hrefs.add(CarShopConst.ROUTE_HELLO);

        //menu.add(createTab(VaadinIcon.BUG, "Bye", ByeView.class));
        //hrefs.add(CarShopConst.ROUTE_BYE);

        menu.add(createTab(VaadinIcon.CAR, "Car", CarView.class));
        hrefs.add(CarShopConst.ROUTE_CAR);
    }

    private Tab createTab(VaadinIcon icon, String title, Class<? extends Component> viewClass) {
        return createTab(populateLink(new RouterLink(null, viewClass), icon, title));
    }

    private Tab createTab(Component content) {
        Tab tab = new Tab();
        tab.addThemeVariants(TabVariant.LUMO_ICON_ON_TOP);
        tab.add(content);
        return tab;
    }

    private <T extends HasComponents> T populateLink(T a, VaadinIcon icon, String title) {
        a.add(icon.create());
        a.add(title);
        return a;
    }

    public void afterNavigation(AfterNavigationEvent event) {
        String href = event.getLocation().getFirstSegment().isEmpty() ? CarShopConst.ROUTE_BYE
                : event.getLocation().getFirstSegment();

        int index = hrefs.indexOf(href);
        if (index >= 0) {
            menu.setSelectedIndex(index);
        }
    }

}
