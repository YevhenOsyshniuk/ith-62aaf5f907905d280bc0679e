package ua.ithillel.homework.lesson30;

import lombok.SneakyThrows;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileStorageReader implements StorageReader {

    private int lastByte;

    @SneakyThrows
    @Override
    public byte[] read(String fileName) {
        Path path = Path.of(fileName);
        FileStorage.add(fileName);
        return Files.readAllBytes(path);
    }

    @SneakyThrows
    @Override
    public List<byte[]> read(String fileName, int chunkSize) {
        List<byte[]> bytesList = new ArrayList<>();
        FileStorage.add(fileName);
        RandomAccessFile reader = new RandomAccessFile(fileName, "r");
        var fileChannel = reader.getChannel();
        var byteBuffer = ByteBuffer.allocate(chunkSize);
        int incomingBytes;

        while ((incomingBytes = fileChannel.read(byteBuffer)) > 0) {
            int buffIndex = 0;
            var byteArr = new byte[incomingBytes];
            byteBuffer.limit(incomingBytes);
            byteBuffer.flip();

            for (int i = 0; i < byteBuffer.limit(); i++) {
                byteArr[i] = byteBuffer.get(i);
                byteBuffer.position(buffIndex++);
            }
            bytesList.add(byteArr);
            byteBuffer.clear();
        }
        return bytesList;
    }

    @SneakyThrows
    @Override
    public List<byte[]> read(String fileName, Resume resume) {
        List<byte[]> bytesList = new ArrayList<>();
        FileStorage.add(fileName);

        RandomAccessFile reader = new RandomAccessFile(fileName, "r");
        var fileChannel = reader.getChannel();
        var byteBuffer = ByteBuffer.allocate(resume.chunkSize());
        int incomingBytes;

        while ((incomingBytes = fileChannel.read(byteBuffer)) > 0) {
            lastByte = 0;
            int buffIndex = 0;
            var byteArr = new byte[incomingBytes];
            byteBuffer.limit(incomingBytes);
            byteBuffer.flip();

            for (int i = 0; i < byteBuffer.limit(); i++) {
                byteArr[i] = byteBuffer.get(lastByte);
                byteBuffer.position(buffIndex++);
                lastByte++;
            }
            bytesList.add(byteArr);
            byteBuffer.clear();
        }
        resume.setFile(Path.of(fileName));
        resume.setLastReadByte(lastByte);
        return bytesList;
    }
}