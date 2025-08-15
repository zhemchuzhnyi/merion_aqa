package ru.merion.aqa.practiceDZ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

import java.util.List;

public class Task4 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://the-internet.herokuapp.com/entry_ad");

        WebElement element = driver.findElement(By.cssSelector(".modal-footer"));
        element.click();
        List<WebElement> content = driver.findElements(By.cssSelector(".large-12.columns"));

        System.out.println("Текст элемента content: " + content.size());

        driver.quit();


    }

}
