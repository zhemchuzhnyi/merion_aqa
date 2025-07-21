package ru.merion.aqa.lesson3;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.merion.aqa.WebDriverFactory;

import java.io.File;

public class Screenshot {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://play2048.co/");

        ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE).renameTo(new File("res.png"));

        driver.quit();
    }
}
