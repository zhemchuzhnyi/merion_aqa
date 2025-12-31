package ru.merion.aqa.Practics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2New {
    private WebDriver driver;

    @BeforeEach
    public void open(){
        driver = new ChromeDriver();
    }

    @AfterEach
    public void close(){
        if (driver != null){
            driver.quit();
        }
    }

}
