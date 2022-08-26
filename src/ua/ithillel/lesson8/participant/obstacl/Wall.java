package ua.ithillel.lesson8.participant.obstacl;


import ua.ithillel.lesson8.participant.members.Participant;

public class Wall  implements Obstruction {

    private int heightOfWall;

    public Wall(int heightOfWall) {
        this.heightOfWall = heightOfWall;
    }

    @Override
    public String overcome(Participant participant) {
        return (participant.getName() + " перепрыгнул через стену");
    }

    @Override
    public boolean competition(Participant participant) {
        if (heightOfWall < participant.jumpHeight()) {
            System.out.println("Участник " + participant.getName() + " препрыгнул стену " + heightOfWall);
            return true;
        } else {
            System.out.println("Участник  " + participant.getName() + " не перепрыгнул стену " + heightOfWall);
        }
        return false;
    }
}
