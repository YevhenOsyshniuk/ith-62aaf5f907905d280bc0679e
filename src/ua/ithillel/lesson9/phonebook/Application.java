package ua.ithillel.lesson9.phonebook;


public class Application {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Record recordNo1 = new Record("Max", "1111111");
        Record recordNo2 = new Record("Oleh","2222222");
        Record recordNo3 = new Record("Yevhen", "3333333");
        Record recordNo4 = new Record("Oleh", "44444444");
        phonebook.add(recordNo1);
        phonebook.add(recordNo2);
        phonebook.add(recordNo3);
        phonebook.add(recordNo4);
        System.out.println(phonebook.find("Yevhen"));
        System.out.println(phonebook.findAll("Oleh"));
    }
}
