package ua.ithillel.homework.lesson17;

import java.io.File;

public class FileLoggerConfiguration {
    private File file;
    private LoggingLevel loggingLevel;
    private int maxSizeOfFile;
    private String fileFormat = "[CURRENT_TIME][loggingLevel] Message: [MESSAGE]";

    public FileLoggerConfiguration(File file, LoggingLevel loggingLevel, int maxSizeOfFile) {
        this.file = file;
        this.loggingLevel = loggingLevel;
        this.maxSizeOfFile = maxSizeOfFile;
    }

    public FileLoggerConfiguration(File file, LoggingLevel loggingLevel, int maxSizeOfFile, String fileFormat) {
        this.file = file;
        this.loggingLevel = loggingLevel;
        this.maxSizeOfFile = maxSizeOfFile;
        this.fileFormat = fileFormat;
    }

    public File getFile() {
        return file;
    }

    public int getMaxSizeOfFile() {
        return maxSizeOfFile;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "FileLoggerConfiguration{" +
                "file=" + file +
                ", loggingLevel=" + loggingLevel +
                ", fileMaxSize=" + maxSizeOfFile +
                ", fileFormat='" + fileFormat + '\'' +
                '}';
    }
}
