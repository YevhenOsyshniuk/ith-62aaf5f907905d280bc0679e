package ua.ithillel.lesson9.phonebook;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Record recordNo1 = new Record("Max", List.of(111111111));
        Record recordNo2 = new Record("Oleh",List.of(22222222, 55555));
        Record recordNo3 = new Record("Yevhen", List.of(3333333));
        phonebook.add(recordNo1);
        phonebook.add(recordNo2);
        phonebook.add(recordNo3);
        System.out.println(phonebook.find("Yevhen"));
        System.out.println(phonebook.findAll("Oleh"));
    }
}
