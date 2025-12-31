package ru.merion.aqa.Practics;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.merion.aqa.Practics.page.Task1Page;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1New {
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
    @Tags({@Tag("positive"), @Tag("login")})
    @DisplayName("Регистрация с валидными данными")
    public void iCanLogin() {
        String data = new Task1Page(driver)
                .open()
                .enterRegistrationData("tomsmith", "SuperSecretPassword!")
                .getContent();

        assertEquals("You logged into a secure area!\n" +
                "×", data);
    }

    @Test
    @Tags({@Tag("negative"), @Tag("login")})
    @DisplayName("Регистрация с НЕ валидными данными")
    public void iCanLoginNegative() {
        String data = new Task1Page(driver)
                .open()
                .enterRegistrationData("Andrey", "Password!")
                .getContent();

        assertEquals("Your username is invalid!\n" +
                "×", data);

    }
}
