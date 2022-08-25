package ua.ithillel.lesson8.area;

import java.util.Scanner;

public class Circle implements AreaOfFigures {

    @Override
    public int area() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите радиус круга");
        int a = scanner.nextInt();
        int square3 = (int) (Math.PI * a * a);
        System.out.println("Площадь квадрата " + square3);
        return square3;

    }
}
