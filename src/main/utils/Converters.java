package main.utils;

import java.util.*;

public class Converters {

    protected static String[] splitInput(String input){

        return input.split(" ");
    }

    protected static String stringArrayToString(String[] arrayOfStrings){
        StringBuilder builder = new StringBuilder();
        String str;
        for (int i=0; i<arrayOfStrings.length; i++){

            builder.append(arrayOfStrings[i]);

        }
        str = builder.toString();
        return str;

    }

    protected static Map<Integer, List<String>> possibleInterpretations(String[] inputAsArray){
        Map<Integer, List<String>> result = new HashMap<>();
        String expandedString, initialString;
        List<String> inputAsList;

        //Put input as it is initially into the map.
        inputAsList = new ArrayList<>(Arrays.asList(inputAsArray));
        result.put(0, inputAsList);

        for (int i=0; i<inputAsArray.length; i++){

            if (inputAsArray[i].length() == 2 && !inputAsArray[i].endsWith("0")){

                initialString = inputAsArray[i];

                expandedString = inputAsArray[i].substring(0,1) + "0" + inputAsArray[i].substring(1,2);

                inputAsArray[i] = expandedString;

                System.out.println("Expanded String is: "+ expandedString);

                inputAsList = new ArrayList<>(Arrays.asList(inputAsArray));
                result.put(i+1, inputAsList);

            }


        }

        
        for (int i=0; i)

        return result;





    }


}
