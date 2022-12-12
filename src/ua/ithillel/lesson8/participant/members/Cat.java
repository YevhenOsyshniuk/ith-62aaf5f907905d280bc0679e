package ua.ithillel.lesson8.participant.members;

public class Cat extends Participant{
    private static final int MAX_RUN_DISTANCE = 40;
    private static final int MAX_JUMP_HEIGHT = 2;

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Кот " + super.getName() + " бежит");
    }

    @Override
    public void jump() {
        System.out.println("Кот " + super.getName() + " прыгает");
    }

    @Override
    public int runDistance() {
        return  MAX_RUN_DISTANCE;
    }

    @Override
    public int jumpHeight() {
        return  MAX_JUMP_HEIGHT;
    }
}
