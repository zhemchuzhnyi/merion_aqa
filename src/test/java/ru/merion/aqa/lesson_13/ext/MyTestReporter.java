package ru.merion.aqa.lesson_13.ext;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.opentest4j.AssertionFailedError;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MyTestReporter implements TestWatcher, BeforeAllCallback, AfterAllCallback {

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_ HH:mm");
        String filename = LocalDateTime.now().format(dateTimeFormatter) + "_report.html";
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        greenTests = new HashMap<>();
        redTests = new HashMap<>();
        yellowTests = new HashMap<>();
    }

    private Map<String, Method> greenTests;
    private Map<String, Method> redTests;
    private Map<String, Method> yellowTests;

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
