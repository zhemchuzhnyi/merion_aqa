package ru.merion.aqa;

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

public class WebDriverFactory {

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
            case "yandex":
                return createYandex();
            case "librewolf":
                return createLibreWolf();
            default:
                throw new IllegalArgumentException(
                        "Неподдерживаемый тип браузера: " + browserName +
                                ". Ожидается: chrome, firefox, edge, safari, yandex или librewolf");
        }
    }

    public static WebDriver create(SafariOptions options) {
        return new SafariDriver(options);
    }

    public static WebDriver create(FirefoxOptions options) {
        return new FirefoxDriver(options);
    }

    public static WebDriver create(EdgeOptions options) {
        return new EdgeDriver(options);
    }

    public static WebDriver create(ChromeOptions options) {
        File extension = new File(getChromeExtensionPath());
        if (extension.exists()) {
            options.addExtensions(extension);
        }
        return new ChromeDriver(options);
    }

    // Яндекс.Браузер (основан на Chromium)
    public static WebDriver createYandex() {
        ChromeOptions options = new ChromeOptions();
        String yandexPath = "/Applications/Yandex.app/Contents/MacOS/Yandex";
        options.setBinary(yandexPath);
        File extension = new File(getChromeExtensionPath());
        if (extension.exists()) {
            options.addExtensions(extension);
        }

        return new ChromeDriver(options);
    }

    // LibreWolf (основан на Firefox)
    public static WebDriver createLibreWolf() {
        FirefoxOptions options = new FirefoxOptions();
        String librewolfPath = "/Applications/LibreWolf.app/Contents/MacOS/librewolf";
        options.setBinary(librewolfPath);
        return new FirefoxDriver(options);
    }

    // Метод для получения пути к расширению Chrome (можно настроить через конфигурацию)
    private static String getChromeExtensionPath() {
        String defaultPath = "src/main/resources/chrome_ext/User-Agent-Switcher-for-Chrome-Chrome.crx";
        return System.getProperty("chrome.extension.path", defaultPath);
    }
}