package ru.merion.aqa.lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

import java.util.ArrayList;
import java.util.Set;

public class WindowHandles {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");

        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.cssSelector("#content a")).click();
        
        String firstTabId = driver.getWindowHandle();
        Set<String> tabIds = driver.getWindowHandles();
        tabIds.remove(firstTabId);
        String sendTabId = new ArrayList<>(tabIds).get(0);

       driver.switchTo().window(sendTabId);
       String url = driver.getCurrentUrl();
       System.out.println("url = " + url);

       url = driver.getCurrentUrl();
       System.out.println("url = " + url);




    }
}
