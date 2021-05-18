package main.utils;

import java.util.ArrayList;
import java.util.List;

public class Checks {

    public static List<String> performValidGreekPhoneNumberChecks(List<String> listOfInterpretations) {
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



    public static boolean hasValidStartingDigits (String input) {

        if (input.length() == 10){

            return input.startsWith("2") || input.startsWith("69");

        }

        if (input.length() == 14) {
                return input.startsWith("00302") || input.startsWith("003069");
        }

        return false;

        }


    public static boolean hasOnlyNumbers(String[] array) {

        for (int i=0; i<array.length; i++){

            if (!array[i].matches("[0-9][0-9 ]*$")) {
                return false;
            }

        }


        return true;
    }

    public static boolean hasMaximum3DigitSequences(String[] array) {

        for (int i = 0; i<array.length; i++){

            if (array[i].length() > 3) {
                return false;
            }

        }

        return true;
    }

    public static boolean performValidInputChecks(String[] array) {

        if (hasOnlyNumbers(array) == false){

            Messages.displayInputContainsOtherThanNumbersMessage(hasOnlyNumbers(array));
            return false;

        }

        if (hasMaximum3DigitSequences(array) == false){

            Messages.displayInputContainsMoreThan3DigitSequencesMessage(hasMaximum3DigitSequences(array));
            return false;
        }


        return true;
    }

    public static boolean has10or14Digits(String input) {

        return input.length() == 10 || input.length() == 14;
    }


    public static void performAllChecksAndDeliverFinalResult(){

        String input;
        String[] inputAsArray;
        List<String> possibleNumberInterpretations, validOrInvalidPhone;
        boolean isAValidInput;

        do {

            input = Menu.getInitialUserInput();
            inputAsArray = Converters.stringToStringArray(input);

            //Perform basic checks for a valid input.
            isAValidInput = Checks.performValidInputChecks(inputAsArray);

            //If basic input checks are passed, get possible interpretations and perform Valid Greek Phone checks.
            if (isAValidInput){

                possibleNumberInterpretations = Utils.getPossibleInterpretations(inputAsArray);
                validOrInvalidPhone = Checks.performValidGreekPhoneNumberChecks(possibleNumberInterpretations);
                Messages.displayFinalResultMessage(possibleNumberInterpretations, validOrInvalidPhone);
            }

        } while (!isAValidInput);

    }

}



