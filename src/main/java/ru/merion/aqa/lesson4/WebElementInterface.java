package ru.merion.aqa.lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

import java.util.List;

public class WebElementInterface {
    public static void main(String[] args) {
       WebDriver driver = WebDriverFactory.create("chrome");
       driver.get("https://habr.com/ru/articles");

       //кнопка войти
       WebElement element = driver.findElement(By.cssSelector(".tm-header-user-menu__login"));

       //навигация на странице
       WebElement nav = driver.findElement(By.cssSelector(".tm-tabs__scroll-area"));
       List<WebElement> links = nav.findElements(By.cssSelector("span"));
       System.out.println(links.size());

       driver.quit();

    }
}
