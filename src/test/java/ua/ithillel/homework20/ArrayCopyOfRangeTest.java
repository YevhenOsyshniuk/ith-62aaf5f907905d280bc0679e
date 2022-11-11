package ua.ithillel.homework20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayCopyOfRangeTest {
    @Test
    void newArrayToRecMustReturnAllElementsAfterTheLastNumberFour() {
        ArrayCopyOfRange arrayCopyOfRange = new ArrayCopyOfRange();
        int[] testingArray = arrayCopyOfRange.newArrayToRec(1, 3, 2, 4, 6, 7, 4, 5, 6);
        int[] expectArray = new int[]{5, 6};
        Assertions.assertArrayEquals(testingArray, expectArray);
    }

    @Test
    void newArrayToRecMustReturnAllElementsAfterNumberFour() {
        ArrayCopyOfRange arrayCopyOfRange = new ArrayCopyOfRange();
        int[] testingArray = arrayCopyOfRange.newArrayToRec(1, 3, 2, 4, 6, 7, 2, 5, 6);
        int[] expectArray = new int[]{6, 7, 2, 5, 6};
        Assertions.assertArrayEquals(testingArray, expectArray);
    }

    @Test
    void newArrayToRecMustTowRuntimeExceptionIfThereIsNoNumberFourInArray() {
        ArrayCopyOfRange arrayCopyOfRange = new ArrayCopyOfRange();
        int[] testingArray = {1, 3, 2, 6, 7, 5, 6};
        Assertions.assertThrows(RuntimeException.class, () -> arrayCopyOfRange.newArrayToRec(testingArray));
    }

    @Test
    void arrayMustContainingNumbersOneAndFour_incomingArrayContainsOnlyNumberOne() {
        ArrayCopyOfRange arrayCopyOfRange = new ArrayCopyOfRange();
        boolean testingArray = arrayCopyOfRange.containingOneAndFourInArray(1, 1, 1, 1, 1, 1);
        Assertions.assertFalse(testingArray);
    }

    @Test
    void arrayMustContainingNumbersOneAndFour_incomingArrayContainsOnlyNumberFour() {
        ArrayCopyOfRange arrayCopyOfRange = new ArrayCopyOfRange();
        boolean testingArray = arrayCopyOfRange.containingOneAndFourInArray(4, 4, 4, 4, 4, 4);
        Assertions.assertFalse(testingArray);
    }

    @Test
    void arrayMustContainingNumbersOneAndFour_incomingArrayContainsNotOnlyNumberFourAndOne() {
        ArrayCopyOfRange arrayCopyOfRange = new ArrayCopyOfRange();
        boolean testingArray = arrayCopyOfRange.containingOneAndFourInArray(1, 1, 1, 4, 3, 4);
        Assertions.assertFalse(testingArray);
    }

    @Test
    void arrayMustContainingNumbersOneAndFour_incomingArrayContainsOnlyNumberFourAndOne() {
        ArrayCopyOfRange arrayCopyOfRange = new ArrayCopyOfRange();
        boolean testingArray = arrayCopyOfRange.containingOneAndFourInArray(1, 1, 1, 4, 4, 4);
        Assertions.assertTrue(testingArray);
    }
}