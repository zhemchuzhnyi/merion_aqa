package ru.merion.aqa.Practics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.merion.aqa.Practics.page.Task2Page;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2 {
    private WebDriver driver;

    @BeforeEach
    public void open() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void iCanLogin() {
        String data = new Task2Page(driver)
                .open()
                .enterRegistrationData("tomsmith", "SuperSecretPassword!")
                .getContent();  // Возвращает String

        assertEquals("You logged into a secure area!", data);
    }
}
