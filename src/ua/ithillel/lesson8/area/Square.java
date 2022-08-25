package ua.ithillel.lesson8.area;

import java.util.Scanner;

public class Square implements AreaOfFigures {
    @Override
    public int area() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер грани квадрата");
        int a = scanner.nextInt();
        int square1 = a * a;
        System.out.println("Площадь квадрата " + square1);
        return square1;
    }

}
