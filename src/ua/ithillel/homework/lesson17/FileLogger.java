package ua.ithillel.homework.lesson17;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {

    private LocalDateTime createTime;
    private final FileLoggerConfiguration fileLogConfig;

    public FileLogger(FileLoggerConfiguration fileLogConfig) {
        this.fileLogConfig = fileLogConfig;
    }

    public void debug(String massage) {
        if (fileLogConfig.getFile().length() > fileLogConfig.getMaxSizeOfFile()) {
            try {
                createTime = LocalDateTime.now();
                String date = createTime.format(DateTimeFormatter.ISO_DATE_TIME);
                File file = new File("log_" + date);
                fileLogConfig.setFile(file);
                throw new FileMaxSizeReachedException("Превышено максимально значение размера файла. Максимальный розмер " +
                        fileLogConfig.getMaxSizeOfFile() + " байт. Текущий рзамер: " +
                        fileLogConfig.getFile().length() + " байт. Путь файла: " +
                        fileLogConfig.getFile().getAbsolutePath());
            } catch (FileMaxSizeReachedException e) {
                e.printStackTrace();
            }
        }
        writingToDebug(massage);
    }
    public void info(String massage) {
        if (fileLogConfig.getLoggingLevel().equals(LoggingLevel.DEBUG)) {
            debug(massage);
        } else {
            if (fileLogConfig.getFile().length() > fileLogConfig.getMaxSizeOfFile()) {
                try {
                    createTime = LocalDateTime.now();
                    String date = createTime.format(DateTimeFormatter.ISO_DATE_TIME);
                    File file = new File("log_" + date);
                    fileLogConfig.setFile(file);
                    throw new FileMaxSizeReachedException("Превышено максимально значение размера файла. Максимальный розмер "
                            + fileLogConfig.getMaxSizeOfFile() + " байт. Текущий рзамер: "
                            + fileLogConfig.getFile().length() + "байт. Путь файла "
                            + fileLogConfig.getFile().getAbsolutePath());
                } catch (FileMaxSizeReachedException e) {
                    e.printStackTrace();
                }
            }
            writingToInfo(massage);
        }
    }

    private void writingToDebug(String massage) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(fileLogConfig.getFile(), true))) {
            createTime = LocalDateTime.now();
            String newDate = createTime.format(DateTimeFormatter.ISO_DATE_TIME);
            String messageInFile = "[" + newDate + "]" +
                    "[" + fileLogConfig.getLoggingLevel() + "]" + " Message: " + massage + "\n";
            br.write(messageInFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writingToInfo(String massage) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileLogConfig.getFile(), true));
            createTime = LocalDateTime.now();
            String newDate = createTime.format(DateTimeFormatter.ISO_DATE_TIME);
            String messageInFile = "[" + newDate + "]" + "[" + fileLogConfig.getLoggingLevel() + "]" + "[" + massage + "]";
            bufferedWriter.write(messageInFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
