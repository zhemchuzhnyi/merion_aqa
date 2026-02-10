package ru.merion.aqa.practiceTasks.practiceDZ3_1_WebDriver_Page.Task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        ImageGalleryPage gallery = new ImageGalleryPage(driver).open();
        String src = gallery.getImageProperty(2,"src");

        System.out.println("Атрибут src 3й картинки: " + src);

        driver.quit();

    }
}
