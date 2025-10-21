package ru.merion.aqa.practiceDZ3_1.Task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

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