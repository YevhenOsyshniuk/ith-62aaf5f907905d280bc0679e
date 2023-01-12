package ua.ithillel.homework.lesson17;

import java.io.File;

public class Application {
    public static void main(String[] args) {
        File fileForLogs = new File("DEBUG.txt");
        FileLoggerConfiguration fileLoggerConfiguration = new FileLoggerConfiguration(fileForLogs, LoggingLevel.DEBUG,950);
        FileLogger fileLogger = new FileLogger(fileLoggerConfiguration);
        fileLogger.debug("DEBUG message");
        fileLogger.info("INFO message");

        File fileWithConfig = new File("ConfigFile.txt");
        FileLoggerConfigurationLoader fileLogConfLoader = new FileLoggerConfigurationLoader();
        System.out.println(fileLogConfLoader.load(fileWithConfig));
    }
}
