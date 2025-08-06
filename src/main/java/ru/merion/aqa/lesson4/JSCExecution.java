package ru.merion.aqa.lesson4;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

public class JSCExecution {

    public static void main(String[] args) {

        String jsRemoveBanner = "document.querySelector(\".tabs-content\").remove()";
        String jsSetLocalStorage = "localStorage.setItem(\"bestScore\", \"999999999\");";

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("https://mail.ru/");

        ((JavascriptExecutor)driver).executeScript(jsRemoveBanner);


        driver.get("https://2048game.com/ru/");
        ((JavascriptExecutor)driver).executeScript(jsSetLocalStorage);




        driver.quit();
    }
}
