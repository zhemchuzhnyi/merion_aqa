package ru.merion.aqa.lesson3;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class Cookies {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("https://www.labirint.ru/");
        String currentUrl = driver.getCurrentUrl();
        String title = driver.getTitle();
        String pageSource = driver.getPageSource();


        driver.quit();

    }

}
