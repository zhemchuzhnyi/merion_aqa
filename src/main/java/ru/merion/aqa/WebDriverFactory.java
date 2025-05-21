package ru.merion.aqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

    public static WebDriver create(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            return new ChromeDriver();
        }
        if (browserName.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        }

        if (browserName.equalsIgnoreCase("edge")) {
            return new EdgeDriver();
        }

        if (browserName.equalsIgnoreCase("safari")) {
            return new SafariDriver();
        }

        throw new IllegalArgumentException("Неподдерживаемый тип браузера " + browserName + ". [chrome|firefox|edge|safari]");
    }
}
