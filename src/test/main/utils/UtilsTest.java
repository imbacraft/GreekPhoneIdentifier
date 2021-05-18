package main.utils;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class UtilsTest {


    @Test
    void shouldAddZerosToInputItems() {
        String[] array = {"210", "451"};
        List<String> actual1;
        List<List<String>> result = new ArrayList<>();
        List<String> expected1 = new ArrayList<>();
        expected1.add("2010451");
        expected1.add("20104051");
        expected1.add("201040501");

        result = Utils.addZerosToInputItems(result, array);

        actual1 = Converters.convertListOfListsOfStringToListOfString(result);

        Assert.assertArrayEquals(expected1.toArray(), actual1.toArray());

    }

    @Test
    void shouldRemoveZeroes() {
        List<String> listOfItems = new ArrayList<>();
        listOfItems.add("2010451622");
        listOfItems.add("20104051622");
        listOfItems.add("201040501622");

        List<String> actual1;
        actual1 = Utils.removeZeroes(listOfItems);

        List<String> expected1 = new ArrayList<>();
        expected1.add("210451622");
        expected1.add("201451622");
        expected1.add("2010451622");
        expected1.add("2104051622");
        expected1.add("2010451622");
        expected1.add("20104051622");
        expected1.add("21040501622");
        expected1.add("20104051622");
        expected1.add("201040501622");



        Assert.assertArrayEquals(expected1.toArray(), actual1.toArray());


    }
}