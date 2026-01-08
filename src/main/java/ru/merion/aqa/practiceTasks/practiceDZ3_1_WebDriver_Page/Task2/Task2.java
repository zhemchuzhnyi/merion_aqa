package ru.merion.aqa.practiceTasks.practiceDZ3_1_WebDriver_Page.Task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String text = new TextInputPage(driver)
                .open()
                .setButtonName("Merion")
                .getButtonText();

        System.out.println("text = " + text);

        driver.quit();


    }
}