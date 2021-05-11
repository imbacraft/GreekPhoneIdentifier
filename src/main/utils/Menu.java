package main.utils;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    private static Scanner sc;

    public static void mainMenu(){
        String answer;
        boolean hasOnlyNumbers, hasOnly3DigitSequences;
        String[] result;

        Messages.displayWelcomeMessage();

        do {
            //Note that a new Scanner object has to be created for each loop, as a method of clearing previous Scanner input.
            sc = new Scanner(System.in);

            do {
                Messages.displayInputInstructions();
                answer = sc.nextLine();

                hasOnlyNumbers = Checks.hasOnlyNumbers(answer);
                Messages.displayInputContainsOtherThanNumbersMessage(hasOnlyNumbers);

                result = splitAnswer(answer);
                hasOnly3DigitSequences = Checks.hasOnly3DigitSequences(result);
                Messages.displayInputContainsMoreThan3DigitSequencesMessage(hasOnly3DigitSequences);


            } while (hasOnlyNumbers == false || hasOnly3DigitSequences == false);

            System.out.println("Answer contains only numbers is: "+ Checks.hasOnlyNumbers(answer));



            System.out.println("All strings are maximum 3 digits long: "+ Checks.hasOnly3DigitSequences(result));

            System.out.println(Arrays.toString(result));

            Messages.displayRetryQuery();
            answer = sc.nextLine();


        } while (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("Yes"));

        Messages.displayGoodbyeMessage();

        sc.close();

    }



    private static String[] splitAnswer(String answer){
        String[] result = answer.split(" ");

        return result;
    }
}
