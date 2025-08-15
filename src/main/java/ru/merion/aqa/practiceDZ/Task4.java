package ru.merion.aqa.practiceDZ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.merion.aqa.WebDriverFactory;

import java.util.List;

public class Task4 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/entry_ad");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector(".modal-footer")).click();
        List<WebElement> content = driver.findElements(By.cssSelector(".large-12.columns"));

        System.out.println("Текст элемента content: " + content.size());

        driver.quit();


    }

}
