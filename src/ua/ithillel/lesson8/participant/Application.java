package ua.ithillel.lesson8.participant;

import ua.ithillel.lesson8.participant.members.Cat;
import ua.ithillel.lesson8.participant.members.Human;
import ua.ithillel.lesson8.participant.members.Participant;
import ua.ithillel.lesson8.participant.members.Robot;
import ua.ithillel.lesson8.participant.obstacl.Obstruction;
import ua.ithillel.lesson8.participant.obstacl.RunningTrack;
import ua.ithillel.lesson8.participant.obstacl.Wall;

public class Application {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Pushok");
        Robot robot1 = new Robot("Electronik");
        Human human1 = new Human("Yevhen");
        RunningTrack runningTrack = new RunningTrack(30);
        Wall wall = new Wall(1);


        System.out.println(wall.overcome(robot1)); // д.з. пункт 5
        System.out.println(wall.overcome(cat1)); // д.з. пункт 5
        System.out.println(wall.overcome((human1))); // д.з. пункт 5
        System.out.println(runningTrack.overcome(robot1)); // д.з. пункт 5
        System.out.println(runningTrack.overcome(cat1)); // д.з. пункт 5
        System.out.println(runningTrack.overcome(human1)); // д.з. пункт 5

        Participant[] participants = {cat1, human1, robot1}; // д.з. пункт 6
        Obstruction[] classObstacles = {wall, runningTrack}; // д.з. пункт 6
        for (Participant participant : participants) { // д.з. пункт 7
            for (Obstruction classObstacle : classObstacles) {
                String result = classObstacle.overcome(participant);
                System.out.println(result);
            }
        }
        if (runningTrack.competition(cat1)) { //д.з. пункт 8,9
            wall.competition(cat1);
        } else {
            System.out.println(cat1.getName() + " к следующему припятствию не допускается");
        }
    }
}
