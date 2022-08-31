package ua.ithillel.lesson9.phonebook;

import java.util.List;

public final class Record {
    private final String name;
    private final List<Integer> numbers;

    public Record(String name, List<Integer> numbers) {
        this.name = name;
        this.numbers = numbers;
    }


    public String name() {
        return name;
    }

    public List<Integer> numbers() {
        return numbers;
    }

}
