package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.parser.LineParser;
import by.tc.task01.dao.reader.Reader;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApplianceDAOImpl implements ApplianceDAO {

    @Override
    public <E> Appliance find(Criteria<E> criteria) {
        List<String> lines = Reader.getInstance().readFromFile();

        for (Map.Entry<E, Object> e : criteria.getCriteria().entrySet()) {
            lines = lines.stream()
                    .filter(line -> line.contains(e.getKey() + "=" + e.getValue())
                            && line.contains(criteria.getApplianceType()))
                    .collect(Collectors.toList());
        }

        if ( !lines.isEmpty() ) {
            return LineParser.getInstance().parseLine(lines.get(0), criteria.getApplianceType());
        }

        return null;
    }
}
