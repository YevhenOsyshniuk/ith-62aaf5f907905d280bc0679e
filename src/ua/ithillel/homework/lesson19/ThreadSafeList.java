package ua.ithillel.homework.lesson19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadSafeList<T> {
    private List<T> safeList = Collections.synchronizedList(new ArrayList<>());

    public synchronized void add(T someVariable) {
        safeList.add(someVariable);
    }

    public synchronized void remove(int numberOfElement) {
        if (safeList.size() > 0) {
            safeList.remove(numberOfElement);
        }
    }

    public synchronized T get(int numberOfElement) {
        return safeList.get(numberOfElement);
    }
}
