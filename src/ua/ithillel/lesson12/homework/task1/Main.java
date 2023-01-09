package ua.ithillel.lesson12.homework.task1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] integers = {10, 9, 8, 7};
        System.out.println(toList(integers));
    }

    public static <T> List<T> toList(T[] inputArray) {
        return Arrays.asList(inputArray);
    }
}
