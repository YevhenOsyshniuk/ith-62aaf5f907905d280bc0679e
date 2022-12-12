package ua.ithillel.lesson8.participant.obstacl;

import ua.ithillel.lesson8.participant.members.Participant;

public interface Obstruction {
    String overcome(Participant participant);
    boolean competition(Participant participant);
}
