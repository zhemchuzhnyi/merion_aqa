package ru.merion.aqa.lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

public class Click {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");

        driver.get("https://habr.com/ru");
        WebElement login = driver.findElement(By.cssSelector(".tm-header-user-menu__login"));
        login.click();


        driver.quit();

    }
}
