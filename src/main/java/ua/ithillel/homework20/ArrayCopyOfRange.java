package ua.ithillel.homework20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayCopyOfRange {
    public int[] newArrayToRec(int... testArray) {
        int number = 4;
        boolean found = Arrays.stream(testArray).anyMatch(i -> i == number);
        if (!found) {
            throw new RuntimeException("In ArrayCopyOfRange class in newArrayToRec method in testArray there's no 4");
        }
        List<Integer> repeatedIndex = new ArrayList<>();
        for (int i = 0; i < testArray.length; i++) {
            if (testArray[i] == number) {
                repeatedIndex.add(i);
            }
        }
        var maxIndex = Collections.max(repeatedIndex);
        return Arrays.copyOfRange(testArray, maxIndex + 1, testArray.length);
    }

    public boolean containingOneAndFourInArray(int... arrayThatContainsOneAndFour) {
        for (int i = 0; i < arrayThatContainsOneAndFour.length; i++) {
            if (arrayThatContainsOneAndFour[i] != 1 && arrayThatContainsOneAndFour[i] != 4) {
                return false;
            }
        }
        if (Arrays.stream(arrayThatContainsOneAndFour).anyMatch(i -> i == 1)
                && Arrays.stream(arrayThatContainsOneAndFour).anyMatch(i -> i == 4)) {
            return true;
        }
        return false;
    }
}

