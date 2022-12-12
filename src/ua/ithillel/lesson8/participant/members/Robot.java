package ua.ithillel.lesson8.participant.members;

public class Robot extends Participant {
    private static final int MAX_RUN_DISTANCE = 50;
    private static final int MAX_JUMP_HEIGHT = 8;

    public Robot(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Робот " + super.getName() + " бежит");
    }

    @Override
    public void jump() {
        System.out.println("Робот " + super.getName() + " прыгает");
    }

    @Override
    public int runDistance() {
        return MAX_RUN_DISTANCE;
    }

    @Override
    public int jumpHeight() {
        return MAX_JUMP_HEIGHT;
    }
}
