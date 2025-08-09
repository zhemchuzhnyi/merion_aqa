package ru.merion.aqa.lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class Properties {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("https://habr.com/ru/feed/");

        String target1 = driver.findElement(By.cssSelector(".tm-article-title__link")).getAttribute("scrollLeftMax");
        String target2 = driver.findElement(By.cssSelector(".tm-article-title__link")).getDomProperty("scrollLeftMax");
        String target3 = driver.findElement(By.cssSelector(".tm-article-title__link")).getDomAttribute("spellcheck");
        String target4 = driver.findElement(By.cssSelector(".tm-article-title__link")).getCssValue("spellcheck");

        String innerText = driver.findElement(By.cssSelector(".tm-article-title__link")).getAttribute("innerText"); // возвращает любой найденный текст
        System.out.println(innerText);



        driver.quit();
    }
}
