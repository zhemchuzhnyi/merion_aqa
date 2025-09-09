/*
Скрипт на калькулятор
Напишите скрипт. Шаги:

Открыть страницу https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html
В поле ввода по локатору
#delay
 ввести значение 45
Нажать на кнопки
7
+(плюс)
8
=
Дождаться результата. Вывести его в консоль.
 */
package ru.merion.aqa.practiceDZ2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.merion.aqa.WebDriverFactory;

import java.security.Key;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Task5 {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        driver.findElement(By.cssSelector("#delay")).sendKeys(Keys.chord(Keys.LEFT_SHIFT, Keys.ARROW_UP));
        driver.findElement(By.cssSelector("#delay")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.cssSelector("#delay")).sendKeys("45");

        driver.findElement(By.xpath("//span[@class='btn btn-outline-primary' and text()='7']")).click();
        driver.findElement(By.xpath("//span[@class='operator btn btn-outline-success' and text()='+']")).click();
        driver.findElement(By.xpath("//span[@class='btn btn-outline-primary' and text()='8']")).click();
        driver.findElement(By.xpath("//span[@class='btn btn-outline-warning' and text()='=']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45),Duration.ofMillis(100));
        wait.until(ExpectedConditions.textToBe(By.cssSelector(".screen"),"15"));

        WebElement screen = driver.findElement(By.xpath("//div[@class='screen' and text()='15']"));
        String text = screen.getText();
        System.out.println("Результат: " + text);


        driver.quit();
    }
}

