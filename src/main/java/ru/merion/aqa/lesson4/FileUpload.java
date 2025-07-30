package ru.merion.aqa.lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class FileUpload {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("https://the-internet.herokuapp.com/upload");

        driver.findElement(By.cssSelector("#file-upload")).sendKeys("/Users/a0000/IdeaProjects/merion_aqa/btn.png");
        driver.findElement(By.cssSelector("#file-submit")).click();

        driver.quit();


    }
}
