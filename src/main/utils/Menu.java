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
    List<List<String>> result;
    Map<Integer, String> stringMap = new HashMap<>();
    Map<Integer, String> contractedStringMap = new HashMap<>();
    List<String> stringList = new ArrayList<>();
    List<String> removedZeroesList = new ArrayList<>();
    List<String> removedDuplicatesList = new ArrayList<>();

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

        for (List<String> list : result){

            stringList.add(Converters.listOfStringsToString(list));
        }

        stringList.forEach(x-> System.out.println("String List Item is "+ x));

        removedZeroesList = removeZeroes(stringList);

        for (String str : removedZeroesList){

            stringList.add(str);

        }


        removedDuplicatesList = Converters.removeDuplicatesWithStream(stringList);

//        removedDuplicatesList = removeResultsWithoutZeroesBeginning(removedDuplicatesList);

        for (int i = 0; i < removedDuplicatesList.size(); i++){
            int counter = i+1;
            System.out.println("Interpretation "+ counter +": "+ removedDuplicatesList.get(i));


        }



    } while (!hasOnlyNumbers || !hasOnly3DigitSequences || !hasValidStartingDigits || ! has10or14Digits);

}


public static List<String> removeZeroes(List<String> stringList){
    List<String> listOfRemovedZeroes = new ArrayList<>();
    String removedZeros;


    for (int i=0; i<stringList.size(); i++){

        removedZeros = stringList.get(i).replaceFirst("(?:0)+", "");

        if (removedZeros.startsWith("3")){

            removedZeros = removedZeros.replace("3", "003");
        }

        listOfRemovedZeroes.add(removedZeros);
    }

    listOfRemovedZeroes.forEach(x-> System.out.println("List of Removed Zeroes Item is: "+ x));

    return listOfRemovedZeroes;


}

    public static List<String> removeResultsWithoutZeroesBeginning(List<String> stringList){

    for(int i=0; i<stringList.size(); i++){

        if(!stringList.get(i).startsWith("0") && (!stringList.get(i).startsWith("2") || !stringList.get(i).startsWith("6"))){

            System.out.println("String to be removed is: "+ stringList.get(i));
            stringList.remove(i);

        }

    }


    return stringList;
    }




}
