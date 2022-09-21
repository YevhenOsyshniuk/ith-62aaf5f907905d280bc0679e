package ua.ithillel.lesson14.homework;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.lang.Math.random;

public class Application {
    public static void main(String[] args) {
        checkStringIsEmpty("hello");
        checkStringCoincidence("JEKA");
        CargoBox cargoBox = new CargoBox(14);
        box(cargoBox);
        System.out.println(discriminant(3, 2, 3));
        System.out.println(randomizer());
    }

    public static void checkStringIsEmpty(String str) {
        Predicate<String> testString = str1 -> !str1.isEmpty();
        System.out.print(testString.test(str));
        System.out.println();
    }

    public static void checkStringCoincidence(String str) {
        Predicate<String> testString = str1 -> str1.startsWith("J") || str1.startsWith("N") && str1.endsWith("A");
        System.out.println(testString.test(str));
    }

    public static void box(CargoBox cargoBox) {
        Consumer<CargoBox> getBox = box -> System.out.println("Отгрузили ящик с весом " + box.weight());
        Consumer<CargoBox> sentBox = box -> System.out.println("Отправляем ящик с весом " + box.weight());
        getBox.andThen(sentBox).accept(cargoBox);
    }

    public static Double discriminant(double a, double b, double c) {
        List<Double> list = List.of(a, b, c);
        Function<List<Double>, Double> calcFunc = x -> b * b - 4 * a * c;
        return calcFunc.apply(list);
    }

    public static int randomizer() {
        Supplier<Integer> testInt = () -> (int) (random() * 10);
        return testInt.get();
    }
}
