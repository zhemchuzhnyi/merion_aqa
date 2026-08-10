package ru.merion.aqa;

import io.github.bonigarcia.wdm.WebDriverManager;
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
import java.time.Duration;

/**
 * Единая фабрика WebDriver для всех браузеров проекта.
 * Скачивает драйвер через WebDriverManager, чтобы он не зависел от PATH/машины.
 */
public class WebDriverFactory {

    // Базовое неявное ожидание проекта (см. ResultPage.addAllItemsToCart, которое возвращает его обратно)
    private static final Duration DEFAULT_IMPLICIT_WAIT = Duration.ofMillis(500);

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
        WebDriverManager.firefoxdriver().setup();
        return withDefaultTimeout(new FirefoxDriver(options));
    }

    public static WebDriver create(EdgeOptions options) {
        WebDriverManager.edgedriver().setup();
        return withDefaultTimeout(new EdgeDriver(options));
    }

    public static WebDriver create(ChromeOptions options) {
        WebDriverManager.chromedriver().setup();
        File extension = new File(getChromeExtensionPath());
        if (extension.exists()) {
            options.addExtensions(extension);
        }
        return withDefaultTimeout(new ChromeDriver(options));
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
        WebDriverManager.chromedriver().setup();
        return withDefaultTimeout(new ChromeDriver(options));
    }

    // LibreWolf (основан на Firefox)
    public static WebDriver createLibreWolf() {
        FirefoxOptions options = new FirefoxOptions();
        String librewolfPath = "/Applications/LibreWolf.app/Contents/MacOS/librewolf";
        options.setBinary(librewolfPath);
        WebDriverManager.firefoxdriver().setup();
        return withDefaultTimeout(new FirefoxDriver(options));
    }

    private static WebDriver withDefaultTimeout(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT);
        return driver;
    }

    // Метод для получения пути к расширению Chrome (можно настроить через конфигурацию)
    private static String getChromeExtensionPath() {
        String defaultPath = "src/main/resources/chrome_ext/User-Agent-Switcher-for-Chrome-Chrome.crx";
        return System.getProperty("chrome.extension.path", defaultPath);
    }
}
