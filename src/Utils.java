import java.util.Scanner;

public class Utils {

    private static Scanner sc;

    public static void Menu(){
        sc = new Scanner(System.in);
        String answer;

        System.out.println("Welcome! You are speaking to Telephone Number Identificator Bot.");

        do {

            System.out.println("Type a phone number in digit sequences, with each sequence separated with a space." +
                    "\nNote that each sequence can be up to three digits long." +
                    "\nExample: 6 97 400 23 7 40 5");
            answer = sc.next();

            System.out.println("Do you want to retry? (Y/N)");
            answer = sc.next();

        } while (answer.equalsIgnoreCase("Y"));







    }

}
