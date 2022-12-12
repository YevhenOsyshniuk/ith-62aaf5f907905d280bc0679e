package ua.ithillel.lesson9.phonebook;

import java.util.*;
import java.util.stream.Collectors;

public class Phonebook {
    private static List<Record> records;


    public Phonebook() {
        this.records = new ArrayList<>();
    }

    public static void add(Record record) {
        records.add(record);
    }


    public Record find(String name) {
        for (Record record : records) {
            if (record.getName().equals(name)) {
                return record;
            }
        }
        return null;
    }

    public List<Record> findAll(String name) {
        return records.stream().filter(element -> element.getName().equals(name)).collect(Collectors.toList());
    }

}
