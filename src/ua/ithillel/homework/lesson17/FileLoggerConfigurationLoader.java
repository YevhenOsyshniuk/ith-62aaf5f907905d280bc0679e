package ua.ithillel.homework.lesson17;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileLoggerConfigurationLoader {
    private final String FILE_PATH = "FILE";
    private final String LOGGING_LEVEL = "LEVEL";
    private final String MAX_SIZE_OF_FILE = "MAX-SIZE-OF-FILE";
    private final String FORMAT = "FORMAT";
    private LoggingLevel loggingLevel;

    public FileLoggerConfiguration load(File file) {
        Map<String, String> LoginConfiguration = new HashMap<>();
        String[] splitStrings;

        try (BufferedReader bw = new BufferedReader(new FileReader(file))) {
            String text;
            while ((text = bw.readLine()) != null) {
                splitStrings = text.split(": ");
                LoginConfiguration.put(splitStrings[0], splitStrings[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (LoginConfiguration.get(LOGGING_LEVEL).equals("INFO")) {
            loggingLevel = LoggingLevel.INFO;
        } else if (LoginConfiguration.get(LOGGING_LEVEL).equals("DEBUG")) {
            loggingLevel = LoggingLevel.DEBUG;
        }

        return new FileLoggerConfiguration(new File(LoginConfiguration.get(FILE_PATH)),
                loggingLevel, Integer.parseInt(LoginConfiguration.get(MAX_SIZE_OF_FILE)), LoginConfiguration.get(FORMAT));
    }
}
