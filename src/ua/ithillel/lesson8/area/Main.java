package ua.ithillel.lesson8.area;

public class Main {
    public static void main(String[] args) {
        areaOfFigures();
    }

    public static void areaOfFigures() {
        Triangle triangle = new Triangle(6,2);
        Square square = new Square(4);
        Circle circle = new Circle(3);

        FigureArea[] instances = new FigureArea[3];
        instances[0] = square;
        instances[1] = triangle;
        instances[2] = circle;

        int sum = 0;
        for (int i = 0; i < instances.length; i++) {
            sum = sum + instances[i].getArea();
        }
        System.out.println("Площадь всех фигур " + sum + " условных единиц");
    }
}
