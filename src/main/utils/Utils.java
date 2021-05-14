package main.utils;

import java.util.*;
import java.util.stream.Collectors;

public class Utils {

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

    protected static List<String> getPossibleInterpretations(String[] inputAsArray){
        List<List<String>> listOfLists = new ArrayList<>();
        List<String> inputAsList = new ArrayList<>(Arrays.asList(inputAsArray));;
        List<String> listOfRemovedZeroes = new ArrayList<>();
        List<String> result = new ArrayList<>();

        listOfLists.add(inputAsList);

        addZerosToInputItems(listOfLists, inputAsArray);

        result = convertListOfListsOfStringToListOfString(listOfLists);

        listOfRemovedZeroes = removeZeroes(result);

        for (String str : listOfRemovedZeroes){

            result.add(str);
        }

        result = Utils.removeDuplicatesFromListOfStrings(result);

        return result;


            }

    public static void addZerosToInputItems(List<List<String>> result, String[] inputAsArray){
        String addedZeroString, secondAddedZeroString;
        List<String> inputAsList;

        for (int i=0; i<inputAsArray.length; i++) {

            if (inputAsArray[i].length() == 3 && !inputAsArray[i].endsWith("0") && !inputAsArray[i].substring(1,2).startsWith("0")) {

                addedZeroString = inputAsArray[i].substring(0, 1) + "0" + inputAsArray[i].substring(1);
                secondAddedZeroString = inputAsArray[i].substring(0, 2) + "0" + inputAsArray[i].substring(2);

                inputAsArray[i] = addedZeroString;

                inputAsList = new ArrayList<>(Arrays.asList(inputAsArray));
                result.add(inputAsList);

                inputAsArray[i] = secondAddedZeroString;

                inputAsList = new ArrayList<>(Arrays.asList(inputAsArray));
                result.add(inputAsList);

            }

            if (inputAsArray[i].length() == 3 && inputAsArray[i].endsWith("0") && !inputAsArray[i].substring(1,2).startsWith("0")) {

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

    }

    public static List<String> removeDuplicatesFromListOfStrings(List<String> list){

        List<String> listWithoutDuplicates = list.stream()
                .distinct()
                .collect(Collectors.toList());

        return listWithoutDuplicates;

    }

    public static List<String> removeZeroes(List<String> stringList){
        List<String> listOfRemovedZeroes = new ArrayList<>();
        String removedLastSingleZero,removedFirstZeros, removedLastTwoZeros;

        for (int i=0; i<stringList.size(); i++){

            removedFirstZeros = stringList.get(i).replaceFirst("(?:0)+", "");
            removedLastSingleZero = replaceLastOccurrenceOfString(stringList.get(i), "0", "");
            removedLastTwoZeros = replaceLastOccurrenceOfString(stringList.get(i), "00", "");

            listOfRemovedZeroes.add(removedLastSingleZero);
            listOfRemovedZeroes.add(removedLastTwoZeros);
            listOfRemovedZeroes.add(removedFirstZeros);
        }

        return listOfRemovedZeroes;

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

    public static List<String> convertListOfListsOfStringToListOfString (List<List<String>> listToConvert) {
        List<String> result = new ArrayList<>();

        for (List<String> list : listToConvert) {

            result.add(listOfStringsToString(list));
        }

        return result;
    }
}







