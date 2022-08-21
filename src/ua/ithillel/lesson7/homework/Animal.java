package ua.ithillel.lesson7.homework;

public abstract class Animal {
    String name;
    public static int animalCounter;



    public Animal(String name) {
        this.name = name;
        animalCounter++;
    }

    public static int getAnimalCounter() {
        return animalCounter;
    }

    public void runDistance(int distanceOfRun){
    }

   public void swimDistance (int distanceOfSwim){
    }
}
