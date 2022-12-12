package ua.ithillel.lesson8.participant.members;

public abstract class Participant {
    private String name;

    public Participant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void run();

    public abstract void jump();

   public abstract int runDistance();

    public abstract int jumpHeight();
}
