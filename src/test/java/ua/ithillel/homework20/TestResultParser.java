package ua.ithillel.homework20;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;


public class TestResultParser {

    private String testsFound;
    private String testsSuccessful;
    private String testsFailed;
    private LocalDateTime date;

    public String getTestsFound() {
        return testsFound;
    }

    public String getTestsSuccessful() {
        return testsSuccessful;
    }

    public String getTestsFailed() {
        return testsFailed;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @SneakyThrows
    public void parseFileByPath() {
        List<String> result = Files.readAllLines(Paths.get("fileForTest.txt"));
        if (Files.lines(Paths.get("fileForTest.txt"))
                .anyMatch(e -> e.contains("tests found"))) {
            testsFound = result.get(8);
            testsSuccessful = result.get(12);
            testsFailed = result.get(13);
            date = LocalDateTime.now();
        }
    }
}
