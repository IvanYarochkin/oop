package by.tc.task01.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {

    private static final Pattern RANGE_PATTERN = Pattern.compile("\\d{1,7}(\\.\\d{1,7})?(-\\d{1,7}(\\.\\d{1,7})?)?");

    public static boolean validate(String key, Object value) {
        if ( !(value instanceof String || value instanceof Character) ) {
            System.out.println("Value isn't a string.");
            return false;
        }

        if ( key.equals("FREQUENCY_RANGE") ) {
            return isValidRange(value.toString());
        }

        return true;
    }

    private static boolean isValidRange(String value) {
        Matcher rangeMatcher = RANGE_PATTERN.matcher(value);

        if ( !rangeMatcher.matches() ) {
            System.out.println("Incorrect range value. Actual value = " + value + ".");
            return false;
        }

        String[] numbers = value.split("-");
        if ( numbers.length == 2 && Double.parseDouble(numbers[1]) <= Double.parseDouble(numbers[0]) ) {
            System.out.println("The second value = " + numbers[1] + " must be more than the first value = " + numbers[0]);
            return false;
        }

        return true;
    }
}
