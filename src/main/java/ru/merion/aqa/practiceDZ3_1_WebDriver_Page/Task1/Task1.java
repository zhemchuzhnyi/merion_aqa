package ru.merion.aqa.practiceDZ3_1_WebDriver_Page.Task1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));

        AjaxPage page = new AjaxPage(driver);
        page.open();
        page.clickTheButton();
        String content = page.getContent();

        System.out.println("content = " + content);
    }
}
