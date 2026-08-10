package ru.merion.aqa.lesson_13.ext;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.opentest4j.AssertionFailedError;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Формирует простой HTML-отчёт о прошедших тестах в target/reports.
 * Экземпляр расширения один на класс, поэтому поля не static.
 */
public class MyTestReporter implements TestWatcher, BeforeAllCallback, AfterAllCallback {

    private Map<String, String> results;

    public static final String HTML_HEAD = """
            <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <title>Test report</title>
                  <style>
                  .ok {
                        background: #E5FFCC
                  }

                  .failed {
                        background: #FFFFCC
                  }

                  .broken {
                        background: #FFCCCC
                  }
                  </style>
                </head>
                <body>
            """;
    public static final String HTML_TAIL = """
                </body>
                </html>
            """;

    @Override
    public void beforeAll(ExtensionContext context) {
        results = new LinkedHashMap<>();
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        // Двоеточие убрано: оно недопустимо в именах файлов на Windows
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH-mm-ss");
        String filename = LocalDateTime.now().format(dateTimeFormatter) + "_report.html";

        Path reportDir = Path.of("target", "reports");
        Files.createDirectories(reportDir);
        Path reportFile = reportDir.resolve(filename);

        StringBuilder html = new StringBuilder();
        html.append(HTML_HEAD);
        html.append("<p>Test Report Generated</p>");
        html.append("<ol>");

        // ok (успешные), failed (упали на ассерте), broken (упали с ошибкой)
        html.append("<li class=\"ok\">").append(results.getOrDefault("ok", "")).append("</li>");
        html.append("<li class=\"failed\">").append(results.getOrDefault("failed", "")).append("</li>");
        html.append("<li class=\"broken\">").append(results.getOrDefault("broken", "")).append("</li>");

        html.append("</ol>");
        html.append(HTML_TAIL);

        Files.writeString(reportFile, html.toString());
        System.out.println("Отчет: " + reportFile.toAbsolutePath());
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        TestWatcher.super.testSuccessful(context);
        System.out.println(context.getDisplayName());
        addResult("ok", context.getDisplayName());
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
            addResult("failed", context.getDisplayName());
        } else {
            addResult("broken", context.getDisplayName());
        }
    }

    private void addResult(String category, String testName) {
        String prev = results.getOrDefault(category, "");
        results.put(category, prev + "<li>" + testName + "</li>");
    }
}