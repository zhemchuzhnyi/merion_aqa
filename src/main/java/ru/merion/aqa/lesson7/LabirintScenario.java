package ru.merion.aqa.lesson7;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;
import java.util.List;

public class LabirintScenario {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.get("https://www.labirint.ru/");
        Cookie cookie = new Cookie("cookie_policy", "1");
        driver.manage().addCookie(cookie);
        driver.manage().window().maximize();
        driver.get("https://www.labirint.ru/");

        WebElement form = driver.findElement(By.cssSelector("#searchform"));
        form.findElement(By.cssSelector("#search-field")).sendKeys("Java");
        form.submit();

        List<WebElement> cards = driver.findElements(By.cssSelector(".product-card"));
        for (WebElement card : cards) {
            try {
                List<WebElement> buyLinks = card.findElements(By.cssSelector(".buy-link"));
                if (!buyLinks.isEmpty()) {
                    buyLinks.get(0).click();
                }
            } catch (Exception e) {
                // Игнорируем ошибки и продолжаем
            }
        }
        WebElement cartIcon = driver.findElement(By.cssSelector(".j-cart-count"));
        String cartIconCounter = cartIcon.getText();
        System.out.println("Счетчик товаров в иконке Корзине = " + cartIconCounter);
        cartIcon.click();

        String cartCounter = driver.findElement(By.cssSelector("#basket-default-prod-count2")).getText().trim();
        System.out.println("Счетчик товаров в корзине = " + cartCounter);

        String price = driver.findElement(By.cssSelector("#basket-default-sumprice-discount")).getText().trim();
        System.out.println("Цена = " + price);



        driver.quit();
    }
}