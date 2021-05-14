package main.utils;

import java.util.ArrayList;
import java.util.List;

public class Checks {

    protected static List<String> performValidGreekPhoneNumberChecks(List<String> listOfInterpretations) {
        List<String> listOfValidValues = new ArrayList<>();

        for (String str : listOfInterpretations) {

            if (hasValidStartingDigits(str) && has10or14Digits(str)) {

                listOfValidValues.add("[phone number: VALID]");

            } else {

                listOfValidValues.add("[phone number: INVALID]");
            }


        }
        return listOfValidValues;
    }



    protected static boolean hasValidStartingDigits (String input) {

        return input.startsWith("2") || input.startsWith("69") || input.startsWith("00302") ||
                input.startsWith("003069");


        }


    protected static boolean hasOnlyNumbers(String input) {
        if (input.matches("[0-9][0-9 ]*$")) {
            return true;
        }

        return false;
    }

    protected static boolean hasMaximum3DigitSequences(String input) {
        if (input.length() < 3) {
            return true;
        }

        return false;
    }

    protected static boolean performValidInputChecks(String[] array) {
        boolean hasOnlyNumbers;
        boolean hasMaximum3DigitSequences;

        //TODO: hasMaximum3 Digits requires Array of Strings to work

        for (String s : array) {
            hasOnlyNumbers = hasOnlyNumbers(s);
            hasMaximum3DigitSequences = hasMaximum3DigitSequences(s);

            if (hasOnlyNumbers && hasMaximum3DigitSequences) {

                return true;

            } else {

                System.out.println("Maximum digits is: "+ hasMaximum3DigitSequences);
                Messages.displayInputContainsOtherThanNumbersMessage(hasOnlyNumbers);
                Messages.displayInputContainsMoreThan3DigitSequencesMessage(hasMaximum3DigitSequences);


            }
        }

        return false;
    }

    protected static boolean has10or14Digits(String input) {

        return input.length() == 10 || input.length() == 14;
    }

}



