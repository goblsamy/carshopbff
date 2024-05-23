package hu.altcoo.carshopbff.carshopbff.ui.view.garage;


import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.templatemodel.TemplateModel;
import hu.altcoo.carshopbff.carshopbff.backend.dto.CarDTO;
import hu.altcoo.carshopbff.carshopbff.backend.dto.GarageDTO;
import hu.altcoo.carshopbff.carshopbff.backend.service.CarService;
import hu.altcoo.carshopbff.carshopbff.backend.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;

@Tag("garage-grid")
//@JsModule("./src/views/garage-grid.js")
@SpringComponent
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GarageGrid extends PolymerTemplate<TemplateModel> {
    @Id("grid")
    Grid<GarageDTO> grid;

    @Autowired
    GarageService service;

    @PostConstruct
    public void init() {
        grid.addColumn(g -> g.getId()).setHeader("ID").setWidth("50px").setFlexGrow(5).setSortable(true).setSortProperty("id");
        grid.addColumn(g -> g.getGarageName()).setHeader("Garázs neve").setWidth("150px").setFlexGrow(5).setSortable(true).setSortProperty("garageName");
        grid.addColumn(g -> g.getGarageCapacity()).setHeader("Garázs kapacitás").setWidth("50px").setFlexGrow(5).setSortable(true).setSortProperty("garageCapacity");
        grid.addColumn(g -> g.getCars()).setHeader("Autók").setWidth("150px").setFlexGrow(5).setSortable(true).setSortProperty("cars");

        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid.setColumnReorderingAllowed(true);
        grid.getColumns().forEach(column -> column.setResizable(true));
        refresh();
    }

    public void refresh() {
        grid.setItems(service.findAll());
    }
}
