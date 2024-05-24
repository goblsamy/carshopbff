package hu.altcoo.carshopbff.carshopbff.ui.view.garage;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.data.provider.hierarchy.TreeData;
import com.vaadin.flow.data.provider.hierarchy.TreeDataProvider;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.templatemodel.TemplateModel;
import hu.altcoo.carshopbff.carshopbff.backend.dto.CarDTO;
import hu.altcoo.carshopbff.carshopbff.backend.dto.GarageDTO;
import hu.altcoo.carshopbff.carshopbff.backend.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Tag("garage-grid")
@JsModule("./src/views/garage-grid.js")
@SpringComponent
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GarageGrid extends PolymerTemplate<TemplateModel> {

    @Id("grid")
    private TreeGrid<Object> grid; // A típusnak Object-nek kell lennie, hogy kezelni tudja a különböző típusokat

    @Autowired
    GarageService service;

    @PostConstruct
    public void init() {
        setupGrid();
        refresh();
    }

    private void setupGrid() {
        grid.addHierarchyColumn(obj -> {
            if (obj instanceof GarageDTO) {
                return ((GarageDTO) obj).getGarageName();
            } else if (obj instanceof CarDTO) {
                return ((CarDTO) obj).getCarName();
            }
            return null;
        }).setHeader("Garázs neve");

        grid.addColumn(obj -> {
            if (obj instanceof GarageDTO) {
                return ((GarageDTO) obj).getGarageCapacity();
            }
            return ""; // Autók esetében nem jelenítünk meg kapacitást
        }).setHeader("Kapacitás");

        grid.addColumn(obj -> {
            if (obj instanceof CarDTO) {
                return ((CarDTO) obj).getCarType().toString();
            }
            return ""; // Garázsok esetében nem jelenítünk meg típust
        });

        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid.setColumnReorderingAllowed(true);
        grid.getColumns().forEach(column -> column.setResizable(true));
    }

    public void refresh() {
        List<GarageDTO> garages = service.findAll();
        TreeData<Object> treeData = new TreeData<>();

        // Hozzáadom a garázsokat és azok autóit a TreeData-hoz
        for (GarageDTO garage : garages) {
            treeData.addItem(null, garage);  // A garage nincs szülő elemhez kötve
            for (CarDTO car : garage.getCars()) {
                treeData.addItem(garage, car);  // Minden autót a hozzá tartozó garázshoz adok
            }
        }

        // Létrehozom a TreeDataProvider-t a TreeData alapján
        TreeDataProvider<Object> treeDataProvider = new TreeDataProvider<>(treeData);

        // Beállítom a TreeGrid adatforrását
        grid.setDataProvider(treeDataProvider);
    }
}
