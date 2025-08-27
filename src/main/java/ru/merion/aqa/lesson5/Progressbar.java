package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class Progressbar {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://uitestingplayground.com/progressbar");

        driver.findElement(By.cssSelector("#startButton")).click();

        String value = driver.findElement(By.cssSelector("#progressBar")).getAttribute("aria-valuemax");
        System.out.println(value.equals("75"));
        System.out.println(value);

        driver.findElement(By.cssSelector("#stopButton")).click();

        driver.quit();

    }

}
