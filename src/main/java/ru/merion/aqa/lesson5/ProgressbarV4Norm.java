/*
Прогресс бар - правильно решение задачи
 */
package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;

public class ProgressbarV4Norm {

    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://uitestingplayground.com/progressbar");

        driver.findElement(By.cssSelector("#startButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("#progressBar"), "75%"));

        driver.findElement(By.cssSelector("#stopButton")).click();
        System.out.println("Finishe");

        driver.quit();

    }
}
