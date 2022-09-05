package ua.ithillel.homework10;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileNavigator {
    private final Map<String, List<FileData>> fileDataMap = new HashMap<>();

    public void add(String path, FileData file) throws IllegalAccessException {
        if (!file.path().equals(path)) {
            throw new IllegalAccessException("Wrong path");
        } else {
            if (fileDataMap.containsKey(path)) {
                fileDataMap.get(path).add(file);
            } else {
                this.fileDataMap.put(path, Stream.of(file).collect(Collectors.toList()));
            }
        }
    }

    public List<FileData> find(String path) {
        return fileDataMap.get(path);
    }

    public List<List<FileData>> filterBySize(int byteSize) {
        return fileDataMap.values().stream()
                .filter(file -> file.size() <= byteSize).toList();
    }

    public void remove(String path) {
        fileDataMap.remove(path);
    }

    public List<FileData> sortBySize() {

        return fileDataMap.values().stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(FileData::byteSize))
                .collect(Collectors.toList());
    }
}
