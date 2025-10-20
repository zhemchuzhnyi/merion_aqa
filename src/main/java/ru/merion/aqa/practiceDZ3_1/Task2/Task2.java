package ru.merion.aqa.practiceDZ3_1.Task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;

public class Task2 {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.get("http://uitestingplayground.com/textinput");

        driver.findElement(By.cssSelector("#newButtonName")).sendKeys("Merion");
        driver.findElement(By.cssSelector("#updatingButton")).click();
        String content = driver.findElement(By.cssSelector("#updatingButton")).getText();
        System.out.println("Текст кнопки: " + content);

        driver.quit();


    }
}