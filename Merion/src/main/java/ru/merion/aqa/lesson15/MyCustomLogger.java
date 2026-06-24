package ru.merion.aqa.lesson15;

import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyCustomLogger implements HttpLoggingInterceptor.Logger {

    private static final Logger log = LoggerFactory.getLogger(MyCustomLogger.class);

    @Override
    public void log(String message) {
        log.info(message);
    }
}