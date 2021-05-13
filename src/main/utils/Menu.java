package main.utils;

import java.util.*;

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
    Map<Integer, String> stringMap = new HashMap<>();
    Map<Integer, String> contractedStringMap = new HashMap<>();

    boolean hasOnlyNumbers, hasOnly3DigitSequences, hasValidStartingDigits = true, has10or14Digits = true;

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


//        hasValidStartingDigits = Checks.hasValidStartingDigits(properlyFormattedInput);
//        Messages.displayInputHasInvalidStartingDigitsMessage(hasValidStartingDigits, properlyFormattedInput);

        result = Converters.possibleInterpretations(inputAsArray);

        result.values().forEach(x -> System.out.println("Values as String arrays are: " + x.toString()));

        for (Integer i : result.keySet()){

            stringMap.put(i, Converters.listOfStringsToString(result.get(i)));

        }

        contractedStringMap = removeZeroes(stringMap);

        contractedStringMap.forEach(stringMap::putIfAbsent);

        stringMap.values().forEach(x-> System.out.println("Final values as Strings are: "+ x.toString()));

//        for (int i=0; i<result.size(); i++){
//
//            System.out.println(result.get(i).toString());
//
//        }





    } while (!hasOnlyNumbers || !hasOnly3DigitSequences || !hasValidStartingDigits || ! has10or14Digits);

}


public static Map<Integer, String> removeZeroes(Map<Integer, String> stringMap){

    for (int i=0; i<stringMap.size(); i++){

        String contractedString = stringMap.get(i).substring(3);
        String removedZeros = contractedString.replace("0", "");

        System.out.println("Removed Zero String is : "+ removedZeros);
        stringMap.put(i + stringMap.size(), removedZeros);

        System.out.println("Value of contractedStringMap is : "+ stringMap.get(i).toString());



    }

    return stringMap;




}




}
