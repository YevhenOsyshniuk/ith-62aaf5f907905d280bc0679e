package ua.ithillel.lesson12.homework.task2;


import java.util.List;

public class Application {
    public static void main(String[] args) {

        Box<Apples> applesBox = new Box<>();
        Box<Apples> applesBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        List<Orange> someOranges = List.of(new Orange(), new Orange(), new Orange());
        List<Apples> someApples = List.of(new Apples(), new Apples(), new Apples());

        applesBox.addOneTypeOfFruit(new Apples());
        applesBox2.addOneTypeOfFruit(new Apples());
        orangeBox.addOneTypeOfFruit(new Orange());

        applesBox.addManyTypesOfFruits(someApples);
        orangeBox.addManyTypesOfFruits(someOranges);

        System.out.println(applesBox.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(applesBox.compare(orangeBox));

        applesBox.merge(applesBox2);
    }
}
