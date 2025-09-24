package ru.merion.aqa.lesson7;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;

public class LabirintScenario {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.get("https://www.labirint.ru/");
        Cookie cookie = new Cookie("cookie_policy", "1");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        driver.get("https://www.labirint.ru/");

        WebElement element = driver.findElement(By.cssSelector("#search-field"));
        element.sendKeys("Java");
        driver.findElement(By.cssSelector(".b-header-b-search-e-btn")).click();

        driver.findElement(By.cssSelector("#buy979032")).click();
        driver.findElement(By.cssSelector("#buy660316")).click();
        driver.findElement(By.cssSelector("#buy638778")).click();
        driver.findElement(By.cssSelector("#buy615911")).click();
        driver.findElement(By.cssSelector("#buy483189")).click();




        driver.quit();


    }
}
