package main.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Converters {



    public static List<String> convertListOfListsOfStringToListOfString (List<List<String>> listToConvert) {
        List<String> result = new ArrayList<>();

        for (List<String> list : listToConvert) {

            result.add(listOfStringsToString(list));
        }

        return result;
    }

    public static String[] stringToStringArray(String input){

        return input.split(" ");
    }

    public static String listOfStringsToString(List<String> listOfStrings){
        StringBuilder builder = new StringBuilder();
        String str;
        for (int i=0; i<listOfStrings.size(); i++){

            builder.append(listOfStrings.get(i));

        }
        str = builder.toString();
        return str;

    }

}
