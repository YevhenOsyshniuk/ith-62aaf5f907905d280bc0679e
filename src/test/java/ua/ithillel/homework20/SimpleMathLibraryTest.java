package ua.ithillel.homework20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleMathLibraryTest {

    @Test
    void addingTwoPositiveNumbersRetrievePositive() {
        SimpleMathLibrary simpleMathLibrary = new SimpleMathLibrary();
        double actual = simpleMathLibrary.add(5.1, 6.1);
        double expect = 11.2;
        Assertions.assertEquals(expect, actual);
    }

    @Test
    void addingTwoNegativeNumbersRetrieveNegative() {
        SimpleMathLibrary simpleMathLibrary = new SimpleMathLibrary();
        double actual = simpleMathLibrary.add(-5.1, -6.1);
        double expect = -11.2;
        Assertions.assertEquals(expect, actual);
    }

    @Test
    void subtractingTwoNegativeNumbersRetrieveNegative() {
        SimpleMathLibrary simpleMathLibrary = new SimpleMathLibrary();
        double actual = simpleMathLibrary.minus(-5.1, -6.1);
        double expect = 1;
        Assertions.assertEquals(expect, actual);
    }

    @Test
    void subtractingTwoPositiveNumbers() {
        SimpleMathLibrary simpleMathLibrary = new SimpleMathLibrary();
        double actual = simpleMathLibrary.minus(8, 7);
        double expect = 1;
        Assertions.assertEquals(expect, actual);
    }
}