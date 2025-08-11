package ru.merion.aqa.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

import java.util.List;

public class Click {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement element = driver.findElement(By.tagName("button"));
        element.click();
        element.click();
        element.click();
        element.click();
        element.click();
//        for (int i = 0; i < 5; i ++); {
//            element.click();
//        }

        List<WebElement> deleteButtons = driver.findElements(By.className("added-manually"));


        System.out.println("Количество кнопок Delete " + deleteButtons.size());



        driver.quit();


    }
}
