package ru.merion.aqa.lesson7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.File;

public class WDFactory {

    public static WebDriver create(String browserName) {
        if (browserName == null) {
            throw new IllegalArgumentException("Имя браузера не может быть null");
        }

        switch (browserName.toLowerCase()) {
            case "chrome":
                return create(new ChromeOptions());
            case "firefox":
                return create(new FirefoxOptions());
            case "edge":
                return create(new EdgeOptions());
            case "safari":
                return create(new SafariOptions());
            default:
                throw new IllegalArgumentException(
                        "Неподдерживаемый тип браузера: " + browserName + ". Ожидается: chrome, firefox, edge или safari");
        }
    }

    public static WebDriver create(SafariOptions options) {
        return new SafariDriver(options);
    }

    public static WebDriver create(FirefoxOptions options) {
        return new FirefoxDriver(options);
    }

    public static WebDriver create(ChromeOptions options) {
        File extension = new File(getChromeExtensionPath());
        if (extension.exists()) {
            options.addExtensions(extension);
        } else {
            throw new IllegalStateException("Файл расширения Chrome не найден: " + extension.getAbsolutePath());
        }
        return new ChromeDriver(options);
    }

    public static WebDriver create(EdgeOptions options) {
        return new EdgeDriver(options);
    }

    private static String getChromeExtensionPath() {
        String defaultPath = "src/main/resources/chrome_ext/User-Agent-Switcher-for-Chrome-Chrome.crx";
        return System.getProperty("chrome.extension.path", defaultPath);
    }
}