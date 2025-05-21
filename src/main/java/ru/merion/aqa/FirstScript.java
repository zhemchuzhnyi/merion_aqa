package ru.merion.aqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.ru");



    }
}
