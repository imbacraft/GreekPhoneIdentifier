import main.utils.Checks;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ChecksTest {

    @Test
    void performValidGreekPhoneNumberChecks() {
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
    void hasValidStartingDigits() {



    }

    @Test
    void hasOnlyNumbers() {
    }

    @Test
    void hasMaximum3DigitSequences() {
    }

    @Test
    void performValidInputChecks() {
    }

    @Test
    void has10or14Digits() {
    }
}