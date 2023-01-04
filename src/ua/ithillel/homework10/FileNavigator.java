package ua.ithillel.homework10;

import java.util.*;
import java.util.stream.Collectors;


public class FileNavigator {
    private final Map<String, List<FileData>> fileDataMap = new HashMap<>();

    public void add(String path, FileData file) throws IllegalAccessException {
        if (!file.path().equals(path)) {
            throw new IllegalAccessException("Wrong path to adding new file, paths are not equal");
        }
        if (fileDataMap.containsKey(path)) {
            fileDataMap.get(path).add(file);
        } else {
            List<FileData> newList = new ArrayList<>();
            newList.add(file);
            fileDataMap.put(path, newList);
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
