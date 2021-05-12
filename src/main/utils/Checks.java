package main.utils;

public class Checks {

    protected static boolean hasValidStartingDigits(String input) {
        return input.startsWith("2") || input.startsWith("69") || input.startsWith("00302") ||
                input.startsWith("003069");
    }

    protected static boolean hasOnlyNumbers(String input) {
        if (input.matches("[0-9][0-9 ]*$")) {
            return true;
        }

        return false;
    }

    protected static boolean hasMaximum3DigitSequences(String[] array) {
        boolean hasOnlyNumbers;

        for (String s : array) {
            hasOnlyNumbers = hasOnlyNumbers(s);

            if (hasOnlyNumbers == true && s.length() > 3) {

                return false;

            }
        }

        return true;
    }

    protected static boolean has10or14Digits(String input) {
        return input.length() == 10 || input.length() == 14;
    }

}



