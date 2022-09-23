package ua.ithillel.lesson11.homework;

import ua.ithillel.lesson11.homework.exeptions.ArrayDataException;
import ua.ithillel.lesson11.homework.exeptions.ArraySizeException;

public class Application {
    public static void main(String[] args) {
        String[][] data1 = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        ArrayValueCalculator arrayValueCalculator = new ArrayValueCalculator();
        try {
            System.out.println(arrayValueCalculator.doCalc(data1));
        } catch (ArraySizeException | ArrayDataException exception) {
            System.out.println(exception.getMessage());
        }


    }
}
