package ua.ithillel.homework.lesson30;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class FileStorage {

    private static final List<Path> paths = new ArrayList<>();

    public static void  add(String fileName) {
        paths.add(Path.of(fileName));
    }
}
