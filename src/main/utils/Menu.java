package main.utils;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private static Scanner sc;

    public static void mainMenu(){
        String input;

        Messages.displayWelcomeMessage();

        do {
            inputInstructionsAndBasicChecksSubMenu();


            Messages.displayRetryQuery();
            input = sc.nextLine();


        } while (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("Yes"));

        Messages.displayGoodbyeMessage();

        sc.close();
    }


    /**
     * This submenu method displays input instructions to the user and performs two checks for his input-answer:
     *     <ol>
     *         <li>First, it checks if the input contains symbols other than natural numbers.
     *         If true, it displays error message and repeats the loop</li>
     *         <li>Second, it checks if the input contains number sequences larger than 3 digits.
     *         If true, it displays error message and repeats the loop</li>
     *     </ol>
     */
private static void inputInstructionsAndBasicChecksSubMenu(){

    String input;
    String[] inputAsArray;
    String properlyFormattedInput;
    Map<Integer, List<String>> result;
    List<String> finalResult;

    boolean hasOnlyNumbers, hasOnly3DigitSequences, hasValidStartingDigits, has10or14Digits;

    do {
        //Note that a new Scanner object has to be created for each loop, as a method of clearing previous Scanner input.
        sc = new Scanner(System.in);
        Messages.displayInputInstructions();
        input = sc.nextLine();

        hasOnlyNumbers = Checks.hasOnlyNumbers(input);
        Messages.displayInputContainsOtherThanNumbersMessage(hasOnlyNumbers);

        inputAsArray = Converters.splitInput(input);
        hasOnly3DigitSequences = Checks.hasMaximum3DigitSequences(inputAsArray);
        Messages.displayInputContainsMoreThan3DigitSequencesMessage(hasOnly3DigitSequences);

        //Here checks for ambiguities


        properlyFormattedInput = Converters.stringArrayToString(inputAsArray);
        hasValidStartingDigits = Checks.hasValidStartingDigits(properlyFormattedInput);
        Messages.displayInputHasInvalidStartingDigitsMessage(hasValidStartingDigits, properlyFormattedInput);

        has10or14Digits = Checks.has10or14Digits(properlyFormattedInput);
        Messages.displayInputHasNot10or14DigitsMessage(has10or14Digits);

        result = Converters.possibleInterpretations(inputAsArray);

        result.values().forEach(x -> System.out.println(x.toString()));

//        for (int i=0; i<result.size(); i++){
//
//            System.out.println(result.get(i).toString());
//
//        }





    } while (!hasOnlyNumbers || !hasOnly3DigitSequences || !hasValidStartingDigits || ! has10or14Digits);

}




}
