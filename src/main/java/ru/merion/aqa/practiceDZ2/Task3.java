/*
Напишите скрипт. Шаги:

Перейти на сайт https://bonigarcia.dev/selenium-webdriver-java/loading-images.html
Дождаться загрузки 3й картинки
Получить значение атрибута
src
 у 3й картинки
Вывести значение в консоль
 */

package ru.merion.aqa.practiceDZ2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;

public class Task3 {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(16));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#award")));

        String src = driver.findElement(By.cssSelector("#award")).getAttribute("src");
        System.out.println("Атрибут src 3й картинки: " + src);

        driver.quit();

    }
}
