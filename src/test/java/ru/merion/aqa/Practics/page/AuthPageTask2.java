package ru.merion.aqa.Practics.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;

public class AuthPageTask2 {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public AuthPageTask2(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public AuthPageTask2 open() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    public AuthPageTask2 login(String username, String password) {
        driver.findElement(By.cssSelector("#user-name")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector("#login-button")).click();
        return this;
    }

    public AuthPageTask2 burger() {
        driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
        // Ждем, пока элемент станет видимым и интерактивным
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#about_sidebar_link"))).click();
        return this;
    }

    public AuthPageTask2 container() {
        Select dropdown = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        dropdown.selectByValue("hilo");
        return this;
    }

    public AuthPageTask2 goBack() {
        driver.navigate().back();
        return this;
    }

    public String getMainLogo() {
        return driver.findElement(By.cssSelector(".app_logo")).getText();
    }

    public String error() {
        return driver.findElement(By.cssSelector("h3")).getText();
    }

    public String getPrivacyPolicy() {
        return driver.findElement(By.cssSelector(".footer_copy")).getText();
    }

    public String getTitle() {
        return driver.findElement(By.xpath("//span[text()='Products']")).getText();
    }
}