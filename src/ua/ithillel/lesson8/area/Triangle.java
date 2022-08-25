package ua.ithillel.lesson8.area;

import java.util.Scanner;

public class Triangle implements AreaOfFigures {
    @Override
    public int area() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер перепендикуляра к высоте квадрата");
        int a = scanner.nextInt();
        System.out.println("Введите высоту квадрата");
        int h = scanner.nextInt();
        int square2 = a * h / 2;
        System.out.println("Площадь квадрата " + square2);
        return square2;

    }


}
