package ua.ithillel.lesson9.phonebook;


public final class Record {
    private final String name;
    private final String numbers;

    public Record(String name, String numbers) {
        this.name = name;
        this.numbers = numbers;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name= " + name + ", phone=" + numbers;
    }
}
