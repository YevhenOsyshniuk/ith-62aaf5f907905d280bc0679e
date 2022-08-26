package ua.ithillel.lesson8.area;

import java.util.Scanner;

public class Triangle implements FigureArea {

    private final int a;
    private final int h;

    public Triangle(int a, int h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public int getArea() {
        int square2 = a * h / 2;
        System.out.println("Площадь квадрата " + square2);
        return square2;

    }


}
