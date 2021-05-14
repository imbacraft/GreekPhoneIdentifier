package main.utils;

import java.util.*;
import java.util.stream.Collectors;

public class Converters {

    protected static String[] splitInput(String input){

        return input.split(" ");
    }

    protected static String listOfStringsToString(List<String> listOfStrings){
        StringBuilder builder = new StringBuilder();
        String str;
        for (int i=0; i<listOfStrings.size(); i++){

            builder.append(listOfStrings.get(i));

        }
        str = builder.toString();
        return str;

    }

    protected static List<List<String>> possibleInterpretations(String[] inputAsArray){
        List<List<String>> result = new ArrayList<>();
        String expandedString, secondExpandedString;
        List<String> inputAsList;

        inputAsList = new ArrayList<>(Arrays.asList(inputAsArray));
        result.add(inputAsList);

        for (int i=0; i<inputAsArray.length; i++) {

            if (inputAsArray[i].length() == 3 && !inputAsArray[i].endsWith("0") && !inputAsArray[i].substring(1,2).startsWith("0")) {

                expandedString = inputAsArray[i].substring(0, 1) + "0" + inputAsArray[i].substring(1);
                secondExpandedString = inputAsArray[i].substring(0, 2) + "0" + inputAsArray[i].substring(2);

                inputAsArray[i] = expandedString;

                inputAsList = new ArrayList<>(Arrays.asList(inputAsArray));
                result.add(inputAsList);

                inputAsArray[i] = secondExpandedString;

                inputAsList = new ArrayList<>(Arrays.asList(inputAsArray));
                result.add(inputAsList);

            }

            if (inputAsArray[i].length() == 3 && inputAsArray[i].endsWith("0") && !inputAsArray[i].substring(1,2).startsWith("0")) {

                expandedString = inputAsArray[i].substring(0, 1) + "0" + inputAsArray[i].substring(1);
                inputAsArray[i] = expandedString;

                inputAsList = new ArrayList<>(Arrays.asList(inputAsArray));
                result.add(inputAsList);

            }

            if (inputAsArray[i].length() == 2 && !inputAsArray[i].endsWith("0")) {

                expandedString = inputAsArray[i].substring(0, 1) + "0" + inputAsArray[i].substring(1, 2);

                inputAsArray[i] = expandedString;

                inputAsList = new ArrayList<>(Arrays.asList(inputAsArray));
                result.add(inputAsList);

            }






        }

        for (int i=0; i<inputAsArray.length; i++){

            if(inputAsArray[i].endsWith("0")) {

//                inputAsList = new ArrayList<>(Arrays.asList(inputAsArray));
//                result.add(inputAsList);

                expandedString = inputAsArray[i].replace("0", "");


                inputAsArray[i] = expandedString;

                    inputAsList = new ArrayList<>(Arrays.asList(inputAsArray));
                    result.add(inputAsList);




            }

            if (inputAsArray[i].length() == 3 && !inputAsArray[i].endsWith("0") && inputAsArray[i].substring(1,2).startsWith("0")) {

                expandedString = inputAsArray[i].replace("0", "");


                inputAsArray[i] = expandedString;


                inputAsList = new ArrayList<>(Arrays.asList(inputAsArray));
                result.add(inputAsList);
            }

            }





        return result;


            }



    public static <T> List<T> removeDuplicates(List<T> list) {

        // Create a new LinkedHashSet
        Set<T> set = new LinkedHashSet<>();

        // Add the elements to set
        set.addAll(list);

        // Clear the list
        list.clear();

        // add the elements of set
        // with no duplicates to the list
        list.addAll(set);

        // return the list
        return list;
    }


    public static List<String> removeDuplicatesWithStream(List<String> list){

        List<String> listWithoutDuplicates = list.stream()
                .distinct()
                .collect(Collectors.toList());

        return listWithoutDuplicates;

    }

}







