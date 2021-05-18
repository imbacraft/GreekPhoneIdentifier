package main.utils;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ChecksTest {

    @Test
    void shouldPerformValidGreekPhoneNumberChecks() {
        List<String> valids;
        List<String> interpretations = new ArrayList<>();
        List<String> expectedList = new ArrayList<>();

        interpretations.add("342");
        interpretations.add("00306978235020");
        interpretations.add("210 451 622");

        expectedList.add("[phone number: INVALID]");
        expectedList.add("[phone number: VALID]");
        expectedList.add("[phone number: INVALID]");

        valids = Checks.performValidGreekPhoneNumberChecks(interpretations);

        Assert.assertFalse("List of valids should not have been empty.", valids.isEmpty());
        Assert.assertEquals(Arrays.asList(expectedList), Arrays.asList(valids) );


    }

    @Test
    void shouldCheckForValidStartingDigits() {
        String str1 = "00306978123423";
        String str2 = "157202322";
        String str3 = "2198223234";
        String str4 = "";
        String str5 = "00302104518261";
        String str6 = "0030210451826";

        boolean test1 = Checks.hasValidStartingDigits(str1);
        boolean test2 = Checks.hasValidStartingDigits(str2);
        boolean test3 = Checks.hasValidStartingDigits(str3);
        boolean test4 = Checks.hasValidStartingDigits(str4);
        boolean test5 = Checks.hasValidStartingDigits(str5);
        boolean test6= Checks.hasValidStartingDigits(str6);

        Assert.assertEquals(true, test1);
        Assert.assertEquals(false, test2);
        Assert.assertEquals(true, test3);
        Assert.assertEquals(false, test4);
        Assert.assertEquals(true, test5);
        Assert.assertEquals(false, test6);


    }

    @Test
    void shouldCheckForNumbersOnly() {
        String[] testArray1 = {"kjsdf", "+-$", "1-23", "83", "123."};
        String[] testArray2 = {"35", "12"};

        boolean hasOnlyNumbers1 = Checks.hasOnlyNumbers(testArray1);
        boolean hasOnlyNumbers2 = Checks.hasOnlyNumbers(testArray2);

        Assert.assertFalse(hasOnlyNumbers1);
        Assertions.assertTrue(hasOnlyNumbers2);


    }

    @Test
    void shouldCheckForMaximum3DigitSequences() {
        String[] testArray1 = {"123", "4", "0"};
        String[] testArray2 = {"3534", "12"};

        boolean hasMaximum3DigitSequences1 = Checks.hasMaximum3DigitSequences(testArray1);
        boolean hasMaximum3DigitSequences2 = Checks.hasMaximum3DigitSequences(testArray2);

        Assertions.assertTrue(hasMaximum3DigitSequences1);
        Assert.assertFalse(hasMaximum3DigitSequences2);

    }

    @Test
    void shouldPerformValidInputChecks() {
        String[] testArray1 = {"123", "-4", "0"};
        String[] testArray2 = {"3534", "12"};
        String[] testArray3 = {"348", "12", "4"};

        boolean validInput1 = Checks.performValidInputChecks(testArray1);
        boolean validInput2 = Checks.performValidInputChecks(testArray2);
        boolean validInput3 = Checks.performValidInputChecks(testArray3);

        Assertions.assertFalse(validInput1);
        Assert.assertFalse(validInput2);
        Assert.assertTrue(validInput3);
    }

    @Test
    void shouldCheckFor10or14Digits() {
        String string1 = "6978534957";
        String string2 = "210583853";
        String string3 = "00302310830420";

        boolean has10or14Digits1 = Checks.has10or14Digits(string1);
        boolean has10or14Digits2 = Checks.has10or14Digits(string2);
        boolean has10or14Digits3 = Checks.has10or14Digits(string3);

        Assertions.assertTrue(has10or14Digits1);
        Assert.assertFalse(has10or14Digits2);
        Assertions.assertTrue(has10or14Digits3);


    }
}