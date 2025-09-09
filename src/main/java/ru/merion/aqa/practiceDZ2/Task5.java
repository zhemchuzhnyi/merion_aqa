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
import java.time.Duration;

public class Task5 {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        // Первый вариант:
        driver.findElement(By.cssSelector("#delay")).sendKeys(Keys.chord(Keys.LEFT_SHIFT, Keys.ARROW_UP));
        driver.findElement(By.cssSelector("#delay")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.cssSelector("#delay")).sendKeys("45");

        /*
        //Более продвинутый вариант:
        WebElement delayField = driver.findElement(By.cssSelector("#delay"));
        delayField.clear();
        delayField.sendKeys("45");
         */

        // Длинные XPath первоначальный вариант:
        driver.findElement(By.xpath("//span[@class='btn btn-outline-primary' and text()='7']")).click();
        driver.findElement(By.xpath("//span[@class='operator btn btn-outline-success' and text()='+']")).click();
        driver.findElement(By.xpath("//span[@class='btn btn-outline-primary' and text()='8']")).click();
        driver.findElement(By.xpath("//span[@class='btn btn-outline-warning' and text()='=']")).click();

        /*
        //Более простой и компактный вид:
        driver.findElement(By.xpath("//span[text()='7']")).click();
        driver.findElement(By.xpath("//span[text()='+']")).click();
        driver.findElement(By.xpath("//span[text()='8']")).click();
        driver.findElement(By.xpath("//span[text()='=']")).click();
         */

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45),Duration.ofMillis(100));
        wait.until(ExpectedConditions.textToBe(By.cssSelector(".screen"),"15"));

        WebElement screen = driver.findElement(By.cssSelector(".screen"));
        String result = screen.getText();
        System.out.println("Результат сложения чисел: " + result);

        driver.quit();
    }
}

