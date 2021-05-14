package main.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    protected static List<String> getPossibleInterpretations(String[] inputAsArray){
        List<List<String>> listOfLists = new ArrayList<>();
        List<String> inputAsList = new ArrayList<>(Arrays.asList(inputAsArray));;
        List<String> listOfRemovedZeroes;
        List<String> result;

        listOfLists.add(inputAsList);

        addZerosToInputItems(listOfLists, inputAsArray);

        result = Converters.convertListOfListsOfStringToListOfString(listOfLists);

        listOfRemovedZeroes = removeZeroes(result);

        for (String str : listOfRemovedZeroes){

            result.add(str);
        }

        result = Converters.removeDuplicatesFromListOfStrings(result);

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


    public static List<String> removeZeroes(List<String> stringList){
        List<String> listOfRemovedZeroes = new ArrayList<>();
        String removedLastSingleZero,removedFirstZeros, removedLastTwoZeros;

        for (int i=0; i<stringList.size(); i++){

            removedFirstZeros = stringList.get(i).substring(0,4)+ stringList.get(i).substring(4).replaceFirst("(?:0)+", "");
            listOfRemovedZeroes.add(removedFirstZeros);



            removedLastSingleZero = Converters.replaceLastOccurrenceOfString(stringList.get(i), "0", "");
            removedLastTwoZeros = Converters.replaceLastOccurrenceOfString(stringList.get(i), "00", "");


            listOfRemovedZeroes.add(removedLastSingleZero);
            listOfRemovedZeroes.add(removedLastTwoZeros);

        }


        return listOfRemovedZeroes;

    }


}







