package ua.ithillel.lesson8.area;

import java.util.Scanner;

public class Square implements FigureArea {

    private final int a;

    public Square(int a) {
        this.a = a;
    }

    @Override
    public int getArea() {
        int square1 = a * a;
        System.out.println("Площадь квадрата " + square1);
        return square1;
    }

}
