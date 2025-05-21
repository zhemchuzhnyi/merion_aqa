package ru.merion.aqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {

    public static void main(String[] args) {

        WebDriver driver1 = WebDriverFactory.create("opera");
        driver1.get("https:google.com");



    }
}
