package ua.ithillel.homework.lesson30;

import java.util.List;

public interface StorageReader {

    byte[] read(String fileName);

    List<byte[]> read(String fileName, int chunkSize);

    List<byte[]> read(String fileName, Resume resume);
}
