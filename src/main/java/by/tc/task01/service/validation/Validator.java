package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Validator {

    private static final Set<String> doubleList = new HashSet<>();
    private static final Set<String> integerList = new HashSet<>();
    private static final Set<String> stringList = new HashSet<>();

    static {
        stringList.add("FREQUENCY_RANGE");
        stringList.add("COLOR");
        stringList.add("FILTER_TYPE");
        stringList.add("BAG_TYPE");
        stringList.add("WAND_TYPE");

        doubleList.add("BATTERY_CAPACITY");
        doubleList.add("CPU");
        doubleList.add("HEIGHT");
        doubleList.add("WIDTH");
        doubleList.add("OVERALL_CAPACITY");

        integerList.add("MEMORY_ROM");
        integerList.add("SYSTEM_MEMORY");
        integerList.add("DISPLAY_INCHES");
        integerList.add("POWER_CONSUMPTION");
        integerList.add("WEIGHT");
        integerList.add("CAPACITY");
        integerList.add("DEPTH");
        integerList.add("FREEZER_CAPACITY");
        integerList.add("NUMBER_OF_SPEAKERS");
        integerList.add("CORD_LENGTH");
        integerList.add("FLASH_MEMORY_CAPACITY");
        integerList.add("MOTOR_SPEED_REGULATION");
        integerList.add("CLEANING_WIDTH");
    }

    public static <E> boolean criteriaValidator(Criteria<E> criteria) {

        if ( criteria == null || criteria.getCriteria().containsKey(null) || criteria.getCriteria().containsValue(null) ) {
            return false;
        }

        for (Map.Entry<E, Object> element : criteria.getCriteria().entrySet()) {
            if ( doubleList.contains(element.getKey().toString()) && !NumberValidator.doubleValidate(element.getValue()) ) {
                return false;
            } else if ( integerList.contains(element.getKey().toString()) && !NumberValidator.integerValidator(element.getValue()) ) {
                return false;
            } else if ( stringList.contains(element.getKey().toString()) && !StringValidator.validate(element.getKey().toString(), element.getValue()) ) {
                return false;
            }
        }

        return true;
    }
}