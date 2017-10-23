package by.tc.task01.service.validation;

public final class NumberValidator {

    public NumberValidator() {

    }

    public static boolean doubleValidate(Object value) {
        if ( !(value instanceof Number) ) {
            System.out.println("Value isn't a real number.");
            return false;
        }

        return isValidValue((Number) value);
    }

    public static boolean integerValidator(Object value) {
        if ( !(value instanceof Byte || value instanceof Short || value instanceof Integer) ) {
            System.out.println("Value isn't an integer.");
            return false;
        }

        return isValidValue((Number) value);
    }

    private static boolean isValidValue(Number value) {
        if ( value.doubleValue() < 0 ) {
            System.out.println("Value is less than 0.");
            return false;
        }
        return true;
    }
}
