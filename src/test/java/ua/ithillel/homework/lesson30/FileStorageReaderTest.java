package ua.ithillel.homework.lesson30;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;

public class FileStorageReaderTest {
    @SneakyThrows
    @Test
    public void shouldRead_Text_fromFile() {
        var bytes = new FileStorageReader().read("src/test/resources/testfile.txt");
        StringBuilder stringBuilder = new StringBuilder();

        for (byte b : bytes) {
            stringBuilder.append((char) b);
        }
        Assertions.assertEquals("Hello, world", stringBuilder.toString());
    }

    @SneakyThrows
    @Test
    public void shouldRead_TextByChunks_fromFile() {
        var bytes = new FileStorageReader().read("src/test/resources/testfile.txt", 10);
        StringBuilder stringBuilder = new StringBuilder();

        bytes.forEach(
                arr -> {
                    for (byte b : arr) {
                        stringBuilder.append((char) b);
                    }
                }
        );
        Assertions.assertEquals("Hello, world", stringBuilder.toString());
    }

    @Test
    public void shouldThrowNoSuchFileException_ReadingByChunks() {
        var actual = Assertions.assertThrows(NoSuchFileException.class, () ->
                new FileStorageReader().read("testtt.txt", 10)
        ).getMessage();
        var expected = "An error has occurred while reading from file: testtt.txt";
        Assertions.assertEquals(actual, expected);
    }

    @SneakyThrows
    @Test
    public void shouldRead_Text_withResumeConfig_fromFile() {
        var resume = new Resume(10);
        var bytes = new FileStorageReader().read("src/test/resources/testfile.txt", resume);
        var stringBuilder = new StringBuilder();

        bytes.forEach(
                arr -> {
                    for (byte b : arr) {
                        stringBuilder.append((char) b);
                    }
                }
        );
        Assertions.assertEquals("Hello, world", stringBuilder.toString());
    }
}
