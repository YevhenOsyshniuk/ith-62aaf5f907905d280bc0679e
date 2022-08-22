package ua.ithillel.lesson7.homework;

public class Cat extends Animal{
    private static int catCounter;

    public Cat(String name) {
        super(name);
        catCounter++;
    }

    public static int getCatCounter() {
        return catCounter;
    }

    @Override
    public void runDistance(int distanceOfRun) {
        if (distanceOfRun <= 200 ) {
            System.out.println(super.getName() + " run on distance " + distanceOfRun +" meters" );
        } else {
            System.out.println(super.getName() + " don't run such fare");
        }
    }

    @Override
    public void swimDistance(int distanceOfSwim) {
        System.out.println(super.getName() + " can't swim" );
    }
}
