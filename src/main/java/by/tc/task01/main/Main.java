package by.tc.task01.main;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

import static by.tc.task01.entity.criteria.SearchCriteria.Oven;
import static by.tc.task01.entity.criteria.SearchCriteria.Speakers;
import static by.tc.task01.entity.criteria.SearchCriteria.TabletPC;

public class Main {

    public static void main(String[] args) {
        Appliance appliance;

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        Criteria<Oven> criteriaOven = new Criteria();
        criteriaOven.setApplianceType("Oven");
        criteriaOven.add(Oven.CAPACITY, 32);

        appliance = service.find(criteriaOven);
        PrintApplianceInfo.print(appliance);

        criteriaOven = new Criteria<>();
        criteriaOven.setApplianceType("Oven");
        criteriaOven.add(Oven.HEIGHT, 45);
        criteriaOven.add(Oven.DEPTH, 60);

        appliance = service.find(criteriaOven);
        PrintApplianceInfo.print(appliance);

        criteriaOven = new Criteria<>();
        criteriaOven.setApplianceType("Oven");
        criteriaOven.add(Oven.HEIGHT, -45);
        criteriaOven.add(Oven.DEPTH, -60);

        appliance = service.find(criteriaOven);
        PrintApplianceInfo.print(appliance);

        criteriaOven = new Criteria<>();
        criteriaOven.setApplianceType("Oven");
        criteriaOven.add(Oven.HEIGHT, "45");

        appliance = service.find(criteriaOven);
        PrintApplianceInfo.print(appliance);

        criteriaOven = new Criteria<>();
        criteriaOven.setApplianceType("Oven");
        criteriaOven.add(Oven.DEPTH, 60.3);

        appliance = service.find(criteriaOven);
        PrintApplianceInfo.print(appliance);

        Criteria<Speakers> criteriaSpeakers = new Criteria();
        criteriaSpeakers.setApplianceType("Speakers");
        criteriaSpeakers.add(Speakers.FREQUENCY_RANGE, "2-f");

        appliance = service.find(criteriaSpeakers);
        PrintApplianceInfo.print(appliance);

        criteriaSpeakers = new Criteria();
        criteriaSpeakers.setApplianceType("Speakers");
        criteriaSpeakers.add(Speakers.FREQUENCY_RANGE, "2-4");

        appliance = service.find(criteriaSpeakers);
        PrintApplianceInfo.print(appliance);

        Criteria<TabletPC> criteriaTabletPC = new Criteria();
        criteriaTabletPC.setApplianceType("TabletPC");
        criteriaTabletPC.add(TabletPC.COLOR, 11);

        appliance = service.find(criteriaTabletPC);
        PrintApplianceInfo.print(appliance);

        criteriaTabletPC = new Criteria();
        criteriaTabletPC.setApplianceType("TabletPC");
        criteriaTabletPC.add(TabletPC.COLOR, "BlUe");
        criteriaTabletPC.add(TabletPC.DISPLAY_INCHES, 14);
        criteriaTabletPC.add(TabletPC.MEMORY_ROM, 8000);

        appliance = service.find(criteriaTabletPC);
        PrintApplianceInfo.print(appliance);

        Criteria<TabletPC> emptyCriteria = new Criteria();
        emptyCriteria.setApplianceType("TabletPC");

        appliance = service.find(emptyCriteria);
        PrintApplianceInfo.print(appliance);

    }
}
