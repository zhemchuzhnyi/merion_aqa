package ru.merion.aqa.practiceDZ3_1.Task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ImageGalleryPage {
    private final WebDriver driver;

    private final WebDriverWait wait;

    public ImageGalleryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
}
