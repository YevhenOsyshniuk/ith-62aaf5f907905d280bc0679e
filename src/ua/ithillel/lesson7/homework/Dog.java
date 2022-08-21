package ua.ithillel.lesson7.homework;

public class Dog extends Animal{
    public static int dogCounter;

    public Dog(String name) {
        super(name);
        dogCounter++;
    }

    public static int getDogCounter() {
        return dogCounter;
    }

    public void runDistance(int distanceOfRun) {
        if (distanceOfRun <= 500 ) {
            System.out.println(super.name + " run on distance " + distanceOfRun +" meters" );
        } else {
            System.out.println(super.name + " don't run such fare");
        }
    }

    public void swimDistance(int distanceOfSwim) {
        super.swimDistance(distanceOfSwim);
        if (distanceOfSwim <= 10 ) {
            System.out.println(super.name + " swim on distance " + distanceOfSwim +" meters" );
        } else {
            System.out.println(super.name + " don't swim such fare");
        }
    }
}
