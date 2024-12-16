package org.example;

public class ErrorLogger implements Logger {

    @Override
    public void log(String message) {
        System.err.println(message);
    }

}
