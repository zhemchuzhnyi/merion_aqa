/*
EC - Expected Conditions
 */

package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;
import java.util.List;

public class ECDemo {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // дождаться исчезновение (!) элемента
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));

        // дождаться точного количества элементов на странице
        List<WebElement> elements = wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(""), 7));

        // дождаться видимости элемента
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("")))).click();

        // дождаться появления alert/confirm/prompt и перейти в него
        wait.until(ExpectedConditions.alertIsPresent());

        // дождаться отсутствия или скрытия элемента
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(""))));

        // дождаться наличия элемента в DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));

        //
        wait.until(ExpectedConditions.not());





    }
}
