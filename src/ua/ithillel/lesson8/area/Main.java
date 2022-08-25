package ua.ithillel.lesson8.area;

public class Main {
    public static void main(String[] args) {
        areaOfFigures();
/** поиграть с модификаторами доступа */
    }

    public static void areaOfFigures() {
        Triangle triangle = new Triangle();
        Square square = new Square();
        Circle circle = new Circle();

        AreaOfFigures[] instances = new AreaOfFigures[3];
        instances[0] = square;
        instances[1] = triangle;
        instances[2] = circle;

        int sum = 0;
        for (int i = 0; i < instances.length; i++) {
            sum = sum + instances[i].area();
        }
        System.out.println("Площадь всех " + sum + " условных единиц");
    }
}
