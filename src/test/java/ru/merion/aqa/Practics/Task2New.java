package ru.merion.aqa.Practics;

import org.junit.jupiter.api.*;
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

    @Test
    @Tags({@Tag("positive"),@Tag("login")})
    @DisplayName("Вход на сайт с валидными данными")
    public void iCanEnter(){


    }
}
