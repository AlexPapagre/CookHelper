package org.example;

import java.util.InputMismatchException;

public class LoggerFactory {
    private static LoggerFactory instance;

    public static LoggerFactory getInstance() {
        if (instance == null) {
            instance = new LoggerFactory();
        }

        return instance;
    }

    public Logger getLogger(String logger) {
        if (logger.equalsIgnoreCase("console")) {
            return new ConsoleLogger();
        } else if (logger.equalsIgnoreCase("error")) {
            return new ErrorLogger();
        } else {
            throw new InputMismatchException("Logger '" + logger + "' not supported!");
        }
    }
}
