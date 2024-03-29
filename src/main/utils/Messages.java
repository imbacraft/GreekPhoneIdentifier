package main.utils;

import java.util.List;

public class Messages {

    public static void displayWelcomeMessage(){
        System.out.println("Welcome! You are speaking to Greek Telephone Number Validator Bot. I can indentify valid Greek phone numbers from speech input.");
    }

    public static void displayInputInstructions(){

        System.out.println("Type a Greek phone number in digit sequences, with each sequence separated with a space." +
                "\nEach number sequence represents a speech unit." +
                "\nNote that each sequence can be up to three digits long." +
                "\nValid Greek phone numbers are either 10 or 14 digits." +
                "\nIf the number has 10 digits, they must start with ‘2’ or ‘69’. " +
                "\nIf the number has 14 digits, they must start with ‘0 0 30 2’ or ‘0 0 30 69’." +
                "\nExample of valid Greek 10-digit phone number: 6 97 400 23 7 40 5" +
                "\nExample of valid Greek 14-digit phone number: 0 0 30 210 69 30 6 64");

    }

    public static void displayGoodbyeMessage(){

        System.out.println("Ok! Sad to see you go!");

    }

    public static void displayRetryQuery(){

        System.out.println("\nDo you want to retry? (Y/N)");

    }

    public static void displayInputContainsOtherThanNumbersMessage(Boolean answer) {
        if (answer == false) {

            System.out.println("Invalid input. Phone number must contain only natural numbers (0-9). Please try again! \n");

        }

    }

    public static void displayInputContainsMoreThan3DigitSequencesMessage (Boolean check){

            if (check == false){

                System.out.println("Invalid input. Each number sequence must be maximum 3 digits long! Please try again! \n");
            }


        }


    public static void displayFinalResultMessage(List<String> result, List<String> listOfValidValues){
        int counter = 0;

        for (int i = 0; i < result.size(); i++){
            counter++;
            System.out.println("Interpretation "+ counter +": "+ result.get(i) +"   "+ listOfValidValues.get(i));


        }
    }

    }



