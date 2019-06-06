package Logging;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;

public class LogMapper {
    private final static Logger LOGGER = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
    private static ConsoleHandler consoleHandler;
    private static FileHandler fileHandler;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
    LocalDateTime timeNow = LocalDateTime.now();
    private String date = formatter.format(timeNow);

    public LogMapper() {
        LogManager.getLogManager().reset();
        LOGGER.setLevel(Level.ALL);

        consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        LOGGER.addHandler(consoleHandler);

        try {
            fileHandler = new FileHandler(date + " Logfile.log");
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.ALL);

            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "File logging not working!!", e);
        }
    }

    public void logInfo(String msg, Exception ex) {
        if (ex != null) {
            LOGGER.log(Level.INFO, msg, ex);
        } else {
            LOGGER.log(Level.INFO, msg);
        }
    }

    public void logSevere(String msg, Exception ex) {
        if (ex != null) {
            LOGGER.log(Level.SEVERE, msg, ex);
        } else {
            LOGGER.log(Level.SEVERE, msg);
        }
    }

    public void logFine(String msg, Exception ex) {
        if (ex != null) {
            LOGGER.log(Level.FINE, msg, ex);
        } else {
            LOGGER.log(Level.FINE, msg);
        }
    }
}
