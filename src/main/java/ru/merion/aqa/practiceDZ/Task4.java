package ru.merion.aqa.practiceDZ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

public class Task4 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://the-internet.herokuapp.com/entry_ad");
        WebElement element = driver.findElement()



        driver.quit();


    }

}
