package main.utils;

public class Messages {

    public static void displayWelcomeMessage(){
        System.out.println("Welcome! You are speaking to Greek Telephone Number Validator Bot. I can indentify valid Greek phone numbers from speech input.");
    }

    public static void displayInputInstructions(){

        System.out.println("Type a Greek phone number either 10 or 14 digits long, in digit sequences, with each sequence separated with a space." +
                "\nEach number sequence represents a speech unit." +
                "\nNote that each sequence can be up to three digits long." +
                "\nIf the number has 10 digits, they must start with ‘2’ or ‘69’. " +
                "\nIf the number 14 digits, they must start with ‘0 0 30 2’ or ‘0 0 30 69’." +
                "\nExample of 10-digit number: 6 97 400 23 7 40 5" +
                "\nExample of 14-digit number: 0 0 30 210 69 30 6 64");

    }

    public static void displayGoodbyeMessage(){

        System.out.println("Ok! Sad to see you go!");

    }

    public static void displayRetryQuery(){

        System.out.println("Do you want to retry? (Y/N)");

    }

    public static void displayInputContainsOtherThanNumbersMessage(Boolean answer) {
        if (answer == false) {

            System.out.println("Invalid input. Phone number must contain only natural numbers (0-9). Please try again! \n");

        }

    }

    public static void displayInputContainsMoreThan3DigitSequencesMessage (Boolean answer){

            if (answer == false){

                System.out.println("Invalid input. Each number sequence must be maximum 3 digits long! Please try again! \n");
            }


        }

    }



