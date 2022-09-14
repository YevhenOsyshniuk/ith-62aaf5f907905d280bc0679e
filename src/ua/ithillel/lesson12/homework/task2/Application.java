package ua.ithillel.lesson12.homework.task2;


import java.util.List;

public class Application {
    public static void main(String[] args) {

        Box<Apples> applesBox = new Box<>();
        Box<Apples> applesBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        List<Orange> someOranges = List.of(new Orange(), new Orange(), new Orange());
        List<Apples> someApples = List.of(new Apples(), new Apples(), new Apples());

        applesBox.addFruit(new Apples());
        applesBox2.addFruit(new Apples());
        orangeBox.addFruit(new Orange());

        applesBox.addFruit(someApples);
        orangeBox.addFruit(someOranges);

        System.out.println(applesBox.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(applesBox.compare(orangeBox));

        applesBox.merge(applesBox2);
    }
}
