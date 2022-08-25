package ua.ithillel.lesson8.participant.members;

public class Human extends Participant{
    private static final int MAX_RUN_DISTANCE = 200;
    private static final int MAX_JUMP_HEIGHT = 4;

    public Human(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Человек " + super.getName() + " бежит");
    }

    @Override
    public void jump() {
        System.out.println("Человек " + super.getName() + " прыгает");
    }

    @Override
    public int runDistance() {
        return MAX_RUN_DISTANCE;
    }

    @Override
    public int jumpHeight() {
        return  MAX_JUMP_HEIGHT;
    }
}
