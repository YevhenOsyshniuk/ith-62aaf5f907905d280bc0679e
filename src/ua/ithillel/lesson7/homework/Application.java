package ua.ithillel.lesson7.homework;

public class Application {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Pushok");
        Cat cat2 = new Cat("Margo");
        Dog dog1 = new Dog("Keks");
        Dog dog2 = new Dog("Sharik");
        cat1.runDistance(10);
        cat1.swimDistance(15);
        cat2.runDistance(1000);
        cat2.swimDistance(100);
        dog1.runDistance(120);
        dog1.swimDistance(3);
        dog2.runDistance(600);
        dog2.swimDistance(15);

        System.out.println("Cats created: " + Cat.getCatCounter());
        System.out.println("Dogs created: " + Dog.getDogCounter());
        System.out.println("Animals created: " + Animal.getAnimalCounter());
    }
}
