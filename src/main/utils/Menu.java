package main.utils;

import java.util.*;

public class Menu {

    private static Scanner sc;

    public static void mainMenu(){
        String input;

        Messages.displayWelcomeMessage();

        do {

            performAllChecksAndDeliverFinalResult();

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
private static void performAllChecksAndDeliverFinalResult(){

    String input;
    String[] inputAsArray;
    List<String> finalList;
    List<String> listOfValidValues;
    boolean isAValidInput;

    do {

        input = getInitialUserInput();

        inputAsArray = Converters.stringToStringArray(input);

        isAValidInput = Checks.performValidInputChecks(inputAsArray);


        if (isAValidInput){

            finalList = Utils.getPossibleInterpretations(inputAsArray);

            listOfValidValues = Checks.performValidGreekPhoneNumberChecks(finalList);


            Messages.displayFinalResultMessage(finalList, listOfValidValues);
        }



    } while (!isAValidInput);

}


public static String getInitialUserInput(){
    String input;

    //Note that a new Scanner object has to be created for each loop, as a method of clearing previous Scanner input.
    sc = new Scanner(System.in);
    Messages.displayInputInstructions();
    input = sc.nextLine();

    return input;
}

}
