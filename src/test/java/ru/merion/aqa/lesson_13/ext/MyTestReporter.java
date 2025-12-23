package ru.merion.aqa.lesson_13.ext;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.opentest4j.AssertionFailedError;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MyTestReporter implements TestWatcher {

    private final Map<String, Method> greenTests = new HashMap<>();
    private final Map<String, Method> redTests = new HashMap<>();
    private final Map<String, Method> yellowTests = new HashMap<>();

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
