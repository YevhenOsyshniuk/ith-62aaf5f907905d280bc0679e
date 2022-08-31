package ua.ithillel.lesson9.phonebook;

import java.util.*;

public class Phonebook {
    private final ArrayList<Record> records;


    public Phonebook() {
        this.records = new ArrayList<>();
    }

    public void add(Record record) {
        boolean containsRecord = records.contains(record);
        if (!containsRecord) {
            records.add(record);
        } else {
            records.remove(record);
            records.add(record);
        }
        records.add(record);
    }


    public String find(String name) {
        for (Record record : records) {
            if (record.name().equals(name)) {
                return record.numbers().get(0) + record.name();
            }
        }
        return null;
    }

    public String findAll(String name) {
        for (Record record : records) {
            if (record.name().equals(name)) {
                return record.numbers() + record.name();
            }
        }
        return null;
    }
}
