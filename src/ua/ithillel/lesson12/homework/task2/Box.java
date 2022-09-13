package ua.ithillel.lesson12.homework.task2;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruits> {
    private final List<T> boxOfFruits = new ArrayList<>();


    public void addOneTypeOfFruit(T fruit) {
        boxOfFruits.add(fruit);
    }

    public void addManyTypesOfFruits(List<T> newFruits) {
        boxOfFruits.addAll(newFruits);
    }

    public float getWeight() {
        return boxOfFruits.get(0).getWeight() * boxOfFruits.size();
    }

    public boolean compare(Box<? extends Fruits> box) {
        return getWeight() == box.getWeight();
    }

    public void merge(Box<T> box) {
        boxOfFruits.addAll(box.boxOfFruits);
        box.boxOfFruits.clear();
    }
}
