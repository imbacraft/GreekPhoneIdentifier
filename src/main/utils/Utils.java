package main.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    protected static List<String> getPossibleInterpretations(String[] inputAsArray) {
        List<List<String>> listOfLists = new ArrayList<>();
        List<String> listOfRemovedZeroes;
        List<String> result;

        //Convert input as Array to List
        List<String> inputAsList = new ArrayList<>(Arrays.asList(inputAsArray));
        ;

        listOfLists.add(inputAsList);

        //Add zeros to input items where appropriate to get some possible interpretations.
        listOfLists = addZerosToInputItems(listOfLists, inputAsArray);

        //Convert List of List to List.
        result = Converters.convertListOfListsOfStringToListOfString(listOfLists);

        //Loop the list and remove some zeroes to get some more possible interpretations.
        listOfRemovedZeroes = removeZeroes(result);

        //Put the list of items with removed zeroes in the list to be finalized.
        for (String str : listOfRemovedZeroes) {

            result.add(str);
        }

        //Remove duplicate entries from final list.
        result = removeDuplicatesFromListOfStrings(result);

        return result;


    }

    public static List<List<String>> addZerosToInputItems(List<List<String>> result, String[] inputAsArray) {
        String addedZeroString, secondAddedZeroString;
        List<String> inputAsList;

        for (int i = 0; i < inputAsArray.length; i++) {

            if (inputAsArray[i].length() == 3 && !inputAsArray[i].endsWith("0") && !inputAsArray[i].substring(1, 2).startsWith("0")) {

                addedZeroString = inputAsArray[i].substring(0, 1) + "0" + inputAsArray[i].substring(1);
                inputAsArray[i] = addedZeroString;
                inputAsList = new ArrayList<>(Arrays.asList(inputAsArray));
                result.add(inputAsList);

                secondAddedZeroString = inputAsArray[i].substring(0, 3) + "0" + inputAsArray[i].substring(3);
                inputAsArray[i] = secondAddedZeroString;
                inputAsList = new ArrayList<>(Arrays.asList(inputAsArray));
                result.add(inputAsList);


            }

            if (inputAsArray[i].length() == 3 && inputAsArray[i].endsWith("0") && !inputAsArray[i].substring(1, 2).startsWith("0")) {

                addedZeroString = inputAsArray[i].substring(0, 1) + "0" + inputAsArray[i].substring(1);
                inputAsArray[i] = addedZeroString;
                inputAsList = new ArrayList<>(Arrays.asList(inputAsArray));
                result.add(inputAsList);


            }

            if (inputAsArray[i].length() == 2 && !inputAsArray[i].endsWith("0")) {

                addedZeroString = inputAsArray[i].substring(0, 1) + "0" + inputAsArray[i].substring(1, 2);
                inputAsArray[i] = addedZeroString;
                inputAsList = new ArrayList<>(Arrays.asList(inputAsArray));
                result.add(inputAsList);


            }


        }

        return result;

    }


    public static List<String> removeZeroes(List<String> stringList) {
        List<String> listOfRemovedZeroes = new ArrayList<>();
        String removedLastSingleZero, removedFirstZeros, removedLastTwoZeros;

        for (int i = 0; i < stringList.size(); i++) {

            //if phone number starts with 00, start replacing zeroes after the first 4 digits (0030), else start replacing from the beginning.
            if (stringList.get(i).startsWith("00")) {

                removedFirstZeros = stringList.get(i).substring(0, 4) + stringList.get(i).substring(4).replaceFirst("(?:0)+", "");

            } else {

                removedFirstZeros = stringList.get(i).replaceFirst("(?:0)+", "");
            }

            listOfRemovedZeroes.add(removedFirstZeros);

            removedLastSingleZero = replaceLastOccurrenceOfString(stringList.get(i), "0", "");
            removedLastTwoZeros = replaceLastOccurrenceOfString(stringList.get(i), "00", "");

            listOfRemovedZeroes.add(removedLastSingleZero);
            listOfRemovedZeroes.add(removedLastTwoZeros);

        }

        return listOfRemovedZeroes;

    }


    public static List<String> removeDuplicatesFromListOfStrings(List<String> list){

        List<String> listWithoutDuplicates = list.stream()
                .distinct()
                .collect(Collectors.toList());

        return listWithoutDuplicates;

    }

    public static String replaceLastOccurrenceOfString(String string, String toReplace, String replacement) {
        int pos = string.lastIndexOf(toReplace);
        if (pos > -1) {
            return string.substring(0, pos)
                    + replacement
                    + string.substring(pos + toReplace.length());
        } else {
            return string;
        }
    }

}







