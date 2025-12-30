package ru.merion.aqa.Practics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("visual_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();


        driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
        By.xpath("//button[contains(@class, 'MuiButton-contained')][contains(@class, 'accentGreen')][normalize-space() = 'Sign up for free']");



    }
}
