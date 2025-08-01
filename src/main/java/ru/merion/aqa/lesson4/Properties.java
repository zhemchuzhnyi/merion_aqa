package ru.merion.aqa.lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class Properties {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("https://habr.com/ru/feed/");

        String target1 = driver.findElement(By.cssSelector(".tm-article-title__link")).getAttribute("clientHeight");
        String target2 = driver.findElement(By.cssSelector(".tm-article-title__link")).getDomProperty("clientHeight");
        String target3 = driver.findElement(By.cssSelector(".tm-article-title__link")).getDomAttribute("clientHeight");
        String target4 = driver.findElement(By.cssSelector(".tm-article-title__link")).getCssValue("autocorrect");



        driver.quit();
    }
}
