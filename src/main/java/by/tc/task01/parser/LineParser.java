package by.tc.task01.parser;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.VacuumCleaner;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LineParser {

    private static final Pattern VALUE_PATTERN = Pattern.compile("(?<==)((-)|\\d{1,7}(\\.\\d{1,7})?|\\w)+(?=,|;)");

    private LineParser() {
    }

    private static class SingletonHolder {
        private static final LineParser INSTANCE = new LineParser();
    }

    public static LineParser getInstance() {
        return LineParser.SingletonHolder.INSTANCE;
    }

    public Appliance parseLine(String line, String type) {
        Matcher matcher = VALUE_PATTERN.matcher(line);
        List<String> values = new ArrayList<>();
        while (matcher.find()) {
            values.add(matcher.group());
        }
        switch (type) {
            case "Laptop": {
                return new Laptop(Double.parseDouble(values.get(0)), values.get(1), Integer.parseInt(values.get(2))
                        , Integer.parseInt(values.get(3)), Double.parseDouble(values.get(4)), Integer.parseInt(values.get(5)));
            }
            case "Oven": {
                return new Oven(Integer.parseInt(values.get(0)), Integer.parseInt(values.get(1)), Integer.parseInt(values.get(2))
                        , Integer.parseInt(values.get(3)), Double.parseDouble(values.get(4)), Double.parseDouble(values.get(5)));
            }
            case "Refrigerator": {
                return new Refrigerator(Integer.parseInt(values.get(0)), Integer.parseInt(values.get(1)), Integer.parseInt(values.get(2))
                        , Double.parseDouble(values.get(3)), Double.parseDouble(values.get(4)), Double.parseDouble(values.get(5)));
            }
            case "Speakers": {
                return new Speakers(Integer.parseInt(values.get(0)), Integer.parseInt(values.get(1)), values.get(2)
                        , Integer.parseInt(values.get(3)));
            }
            case "TabletPC": {
                return new TabletPC(Double.parseDouble(values.get(0)), Integer.parseInt(values.get(1)), Integer.parseInt(values.get(2))
                        , Integer.parseInt(values.get(3)), values.get(4));
            }
            case "VacuumCleaner": {
                return new VacuumCleaner(Integer.parseInt(values.get(0)), values.get(1), values.get(2), values.get(3)
                        , Integer.parseInt(values.get(4)), Integer.parseInt(values.get(5)));
            }
            default: {
                return null;
            }
        }
    }
}
