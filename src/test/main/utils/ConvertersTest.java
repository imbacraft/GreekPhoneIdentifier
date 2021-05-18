package main.utils;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ConvertersTest {

    @Test
    void shouldRemoveDuplicatesFromListOfStrings() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("b");
        list1.add("c");

        List<String> listToTest = Utils.removeDuplicatesFromListOfStrings(list1);

        List<String> expectedList = new ArrayList<>();
        expectedList.add("a");
        expectedList.add("b");
        expectedList.add("c");

        Assert.assertArrayEquals(expectedList.toArray(), listToTest.toArray());



    }

    @Test
    void shouldReplaceLastOccurrenceOfString() {
        String string1 = "Party";
        String expected = "Parties";
        String actual;

        actual = Utils.replaceLastOccurrenceOfString(string1,"y", "ies");

        Assert.assertEquals(expected, actual);



    }


}