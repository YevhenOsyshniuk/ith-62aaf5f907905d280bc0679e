package ua.ithillel.lesson8.participant.obstacl;


import ua.ithillel.lesson8.participant.members.Participant;

public class RunningTrack extends Obstacles implements iObstacles {

    private int distanceOfTrack;

    public RunningTrack(int distanceOfTrack) {
        this.distanceOfTrack = distanceOfTrack;
    }

    @Override
    public String overcome(String name) {
        return (name + " пробежал беговую дорожку");
    }

    @Override
    public boolean competition(Participant participant) {
        if (distanceOfTrack < participant.runDistance()) {
            System.out.println("Участник " + participant.getName() + " пробежал дистанцию " + distanceOfTrack);
            return true;
        } else {
            System.out.println("Участник  " + participant.getName() + " не пробежал припятсвие " + distanceOfTrack);
        }
        return false;
    }
}
