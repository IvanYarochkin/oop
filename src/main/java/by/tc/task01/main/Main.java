package by.tc.task01.main;

import by.tc.task01.dao.writer.Writer;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

import static by.tc.task01.entity.criteria.SearchCriteria.Oven;
import static by.tc.task01.entity.criteria.SearchCriteria.TabletPC;

public class Main {

    public static void main(String[] args) {
        Writer.getInstance().write();
        Appliance appliance;

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        //////////////////////////////////////////////////////////////////

        Criteria<Oven> criteriaOven = new Criteria();
        criteriaOven.setApplianceType("Oven");
        criteriaOven.add(Oven.CAPACITY, 32);

        appliance = service.find(criteriaOven);


        by.tc.task01.entity.Oven oven = (by.tc.task01.entity.Oven) appliance;
        //if(oven.getCapacity() == 3) {}

        PrintApplianceInfo.print(appliance);

        //////////////////////////////////////////////////////////////////

        criteriaOven = new Criteria<Oven>();
        criteriaOven.add(Oven.HEIGHT, 200);
        criteriaOven.add(Oven.DEPTH, -300);

        appliance = service.find(criteriaOven);

        PrintApplianceInfo.print(appliance);

        //////////////////////////////////////////////////////////////////

        Criteria<TabletPC> criteriaTabletPC = new Criteria();
        criteriaTabletPC.setApplianceType("TabletPC");
        criteriaTabletPC.add(TabletPC.COLOR, "BLUE");
        criteriaTabletPC.add(TabletPC.DISPLAY_INCHES, 14);
        criteriaTabletPC.add(TabletPC.MEMORY_ROM, 4);

        appliance = service.find(criteriaTabletPC);

        PrintApplianceInfo.print(appliance);

        Writer.getInstance().deleteFile();

    }

}
