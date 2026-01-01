package ru.merion.aqa.Practics;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.merion.aqa.Practics.page.AuthPageTask2;

import java.nio.channels.ConnectionPendingException;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        String data = new AuthPageTask2(driver)
                .open()
                .login("visual_user","secret_sauce")
                .burger()
                .goBack()
                .getMainLogo();

        assertEquals("Swag Labs" , data);
    }

    @Test
    @Tags({@Tag("negative"),@Tag("login")})
    @DisplayName("Вход на сайт с невалидными данными")
    public void iCanNotEnter(){

    }
}
