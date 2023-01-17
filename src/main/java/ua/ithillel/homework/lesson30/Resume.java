package ua.ithillel.homework.lesson30;

import lombok.Setter;

import java.nio.file.Path;

@Setter
public class Resume {
    private Path file;
    private int lastReadByte;

    private final int chunkSize;

    public Resume(int chunkSize) {
        this.chunkSize = chunkSize;
    }

    public int chunkSize() {
        return chunkSize;
    }
}
