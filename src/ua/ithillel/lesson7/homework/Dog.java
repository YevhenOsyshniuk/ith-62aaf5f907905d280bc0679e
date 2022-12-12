package ua.ithillel.lesson7.homework;

public class Dog extends Animal{
    private static int dogCounter;

    public Dog(String name) {
        super(name);
        dogCounter++;
    }

    public static int getDogCounter() {
        return dogCounter;
    }

    @Override
    public void runDistance(int distanceOfRun) {
        if (distanceOfRun <= 500 ) {
            System.out.println(super.getName() + " run on distance " + distanceOfRun +" meters" );
        } else {
            System.out.println(super.getName() + " don't run such fare");
        }
    }

    @Override
    public void swimDistance(int distanceOfSwim) {
        if (distanceOfSwim <= 10 ) {
            System.out.println(super.getName() + " swim on distance " + distanceOfSwim +" meters" );
        } else {
            System.out.println(super.getName() + " don't swim such fare");
        }
    }
}
