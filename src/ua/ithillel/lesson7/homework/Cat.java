package ua.ithillel.lesson7.homework;

public class Cat extends Animal{
    public static int catCounter;

    public Cat(String name) {
        super(name);
        catCounter++;
    }

    public static int getCatCounter() {
        return catCounter;
    }

    public void runDistance(int distanceOfRun) {
        super.runDistance(distanceOfRun);
        if (distanceOfRun <= 200 ) {
            System.out.println(super.name + " run on distance " + distanceOfRun +" meters" );
        } else {
            System.out.println(super.name + " don't run such fare");
        }
    }

    public void swimDistance(int distanceOfSwim) {
        super.swimDistance(distanceOfSwim);
        System.out.println(super.name + " can't swim" );
    }
}
