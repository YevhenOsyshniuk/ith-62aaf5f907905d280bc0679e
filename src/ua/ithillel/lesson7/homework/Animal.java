package ua.ithillel.lesson7.homework;

public abstract class Animal {
    private final String name;
    private static int animalCounter;

    protected Animal(String name) {
        this.name = name;
        animalCounter++;
    }
    public String getName() {
        return name;
    }

    public static int getAnimalCounter() {
        return animalCounter;
    }

    public abstract void runDistance(int distanceOfRun);

    public abstract void swimDistance(int distanceOfSwim);
}
