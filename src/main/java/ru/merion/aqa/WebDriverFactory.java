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

public class WebDriverFactory {

    public static WebDriver create(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            return create( new ChromeOptions());
        }
        if (browserName.equalsIgnoreCase("firefox")) {
            return create(new FirefoxOptions());
        }
        if (browserName.equalsIgnoreCase("edge")) {
            return create(new EdgeOptions());
        }
        if (browserName.equalsIgnoreCase("safari")) {
            return create(new SafariOptions());
        }
        throw new IllegalArgumentException("Неподдерживаемый тип браузера " + browserName + ". (chrome|firefox|edge|safari)");
    }

    public static WebDriver create(SafariOptions options) {
        return new SafariDriver(options);
    }

    public static WebDriver create(FirefoxOptions options) {
        return new FirefoxDriver(options);
    }

    public static WebDriver create(ChromeOptions options) {
        return new ChromeDriver(options);
    }

    public static WebDriver create(EdgeOptions options) {
        return new EdgeDriver(options);
    }
}