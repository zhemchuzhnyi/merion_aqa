package ru.merion.aqa.lesson_12;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametrizedTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.create("chrome");
        driver.get("http://uitestingplayground.com/sampleapp");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"Test", "Тест", "_", "12345", "mail@mail.ru"})
    public void happyTest(String username) {
        driver.findElement(By.cssSelector("[name=UserName]")).sendKeys(username);
        driver.findElement(By.cssSelector("[name=Password]")).sendKeys("pwd");
        driver.findElement(By.cssSelector("#login")).click();

        String msg = driver.findElement(By.cssSelector("#loginstatus")).getText();
        assertEquals("Welcome, " + username + "!", msg);
    }

//    @Test
//    @DisplayName("Пустые поля")
//    public void unauthorized1() {tryToAuth("","");}
//
//    @Test
//    @DisplayName("Вход только с паролем")
//    public void unauthorized2() {tryToAuth("","pwd");}
//
//    @Test
//    @DisplayName("Вход только с логином")
//    public void unauthorized3() {tryToAuth("Test","");}
//
//    @Test
//    @DisplayName("Вход по корректным данным")
//    public void unauthorized4() {tryToAuth("Test","pwd");}

    @ParameterizedTest

    public void tryToAuth(String login, String pass) {
        driver.findElement(By.cssSelector("[name=UserName]")).sendKeys(login);
        driver.findElement(By.cssSelector("[name=Password]")).sendKeys(pass);
        driver.findElement(By.cssSelector("#login")).click();

        String msg = driver.findElement(By.cssSelector("#loginstatus")).getText();
        assertEquals("Invalid username/password", msg);
    }

}
