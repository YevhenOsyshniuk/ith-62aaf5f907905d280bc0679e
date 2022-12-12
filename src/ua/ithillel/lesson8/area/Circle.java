package ua.ithillel.lesson8.area;

import java.util.Scanner;

public class Circle implements FigureArea {

    private final int a;

    public Circle(int a) {
        this.a = a;
    }

    @Override
    public int getArea() {
        int square3 = (int) (Math.PI * a * a);
        System.out.println("Площадь квадрата " + square3);
        return square3;

    }
}
