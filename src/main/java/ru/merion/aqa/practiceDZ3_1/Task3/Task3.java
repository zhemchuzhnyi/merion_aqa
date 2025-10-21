package ru.merion.aqa.practiceDZ3_1.Task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;

public class Task3 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        ImageGalleryPage gallery = new ImageGalleryPage(driver).open();
        String src = gallery.getImageProperty(2,"src");

        System.out.println("Атрибут src 3й картинки: " + src);

        driver.quit();

    }
}
