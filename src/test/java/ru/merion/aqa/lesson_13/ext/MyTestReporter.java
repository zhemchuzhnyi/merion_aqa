package ru.merion.aqa.lesson_13.ext;

import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.opentest4j.AssertionFailedError;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MyTestReporter implements TestWatcher, BeforeAllCallback, AfterAllCallback {

    private static Map<String, Method> greenTests;
    private static Map<String, Method> redTests;
    private static Map<String, Method> yellowTests;

    public static final String HTML_HEAD = """
            <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <title>#[[$Title$]]#</title>
                </head>
                <body>
            """;
    public static final String HTML_TAIL = """
                </body>
                </html>
            """;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        greenTests = new HashMap<>();
        redTests = new HashMap<>();
        yellowTests = new HashMap<>();
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH:mm");
        String filename = LocalDateTime.now().format(dateTimeFormatter) + "_report.html";
        System.out.println("Отчет: " + filename);

        Path reportFile = Path.of(filename);

        Files.writeString(reportFile, HTML_HEAD);
        Files.writeString(reportFile, "<p> Hello! </p>", StandardOpenOption.APPEND);
        Files.writeString(reportFile, HTML_TAIL, StandardOpenOption.APPEND);
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        TestWatcher.super.testSuccessful(context);
        System.out.println(context.getDisplayName());
        greenTests.put(context.getDisplayName(), context.getRequiredTestMethod());
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testFailed(context, cause);
        System.out.println(context.getDisplayName());

        if (cause instanceof AssertionFailedError) {
            yellowTests.put(context.getDisplayName(), context.getRequiredTestMethod());
        } else {
            redTests.put(context.getDisplayName(), context.getRequiredTestMethod());
        }
    }
}