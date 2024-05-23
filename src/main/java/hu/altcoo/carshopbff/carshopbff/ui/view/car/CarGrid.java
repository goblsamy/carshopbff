package hu.altcoo.carshopbff.carshopbff.ui.view.car;


import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.templatemodel.TemplateModel;
import hu.altcoo.carshopbff.carshopbff.backend.dto.CarDTO;
import hu.altcoo.carshopbff.carshopbff.backend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;

@Tag("car-grid")
@JsModule("./src/views/car-grid.js")
@SpringComponent
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CarGrid extends PolymerTemplate<TemplateModel> {
    @Id("grid")
    Grid<CarDTO> grid;

    @Autowired
    CarService service;

    @PostConstruct
    public void init() {

        grid.addColumn(c -> c.getCarType().toString()).setHeader("Autó típusa").setWidth("150px").setFlexGrow(5).setSortable(true).setSortProperty("carType");
        grid.addColumn(c -> c.getCarName()).setHeader("Autó neve").setWidth("150px").setFlexGrow(5).setSortable(true).setSortProperty("carName");

        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid.setColumnReorderingAllowed(true);
        grid.getColumns().forEach(column -> column.setResizable(true));
        refresh();
    }

    public void refresh() {
        grid.setItems(service.findAll());
    }
}
