package main.utils;

import java.util.*;

public class Menu {

    private static Scanner sc;

    public static void mainMenu(){
        String input;

        Messages.displayWelcomeMessage();

        do {
            Checks.performAllChecksAndDeliverFinalResult();

            Messages.displayRetryQuery();
            input = sc.nextLine();

        } while (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("Yes"));

        Messages.displayGoodbyeMessage();

        sc.close();
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
