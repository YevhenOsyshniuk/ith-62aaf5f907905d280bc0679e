package ua.ithillel.lesson11.homework;

import ua.ithillel.lesson11.homework.exeptions.ArrayDataException;
import ua.ithillel.lesson11.homework.exeptions.ArraySizeException;

public class ArrayValueCalculator {

    private int numbersSum = 0;

    public int doCalc(String[][] data) {
        if (!(data.length == 4) || !(data[0].length == 4)) {
            throw new ArraySizeException("Array size is not 4*4, current size is: " + data.length + "x" + data[0].length);
        } else {
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data.length; j++) {
                    try {
                        numbersSum += Integer.parseInt(data[i][j]);
                    } catch (NumberFormatException exception) {
                        throw new ArrayDataException("Inappropriate type of variable in cell with index: " + i + " " + j);
                    }
                }
            }
        }
        return numbersSum;
    }
}