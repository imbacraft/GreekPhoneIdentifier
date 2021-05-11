package Utils;

import Messages.Messages;

import java.util.Scanner;

public class Utils {

    private static Scanner sc;

    public static void Menu(){
        sc = new Scanner(System.in);
        String answer;

        Messages.displayWelcomeMessage();

        do {

            Messages.displayInputInstructions();
            answer = sc.next();


            //TODO Create a method that takes the answer as a parameter.

            Messages.displayRetryQuery();
            answer = sc.next();

        } while (answer.equalsIgnoreCase("Y"));

        Messages.displayGoodbyeMessage();

        sc.close();

    }

private static String checkAnswer(String answer){


    return answer;
}


}
