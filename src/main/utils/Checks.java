package main.utils;

public class Checks {

    protected static boolean checkForValidStartingDigits(String answer) {
        boolean validStartingDigits = answer.startsWith("2") || answer.startsWith("69") || answer.startsWith("6 9") ||
                answer.startsWith("0 0 30 2") || answer.startsWith("00 30 2") || answer.startsWith("0 0 3 0 2") || answer.startsWith("00 3 0 2") ||
                answer.startsWith("0 0 30 69") || answer.startsWith("00 30 69") || answer.startsWith("0 0 3 0 69") || answer.startsWith("0 0 30 6 9");


        return validStartingDigits;
    }

    protected static boolean hasOnlyNumbers(String answer) {
        if (answer.matches("[0-9][0-9 ]*$")) {
            return true;
        }

        return false;
    }

    protected static boolean hasOnly3DigitSequences(String[] array) {
        boolean hasOnlyNumbers;

        for (String s : array) {
            hasOnlyNumbers = hasOnlyNumbers(s);

            if (hasOnlyNumbers == true && s.length() > 3) {

                return false;

            }
        }

        return true;
    }

}



