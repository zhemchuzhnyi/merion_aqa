package ru.merion.aqa.lesson_12;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ParametrizedTestNotGood {
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

    @ParameterizedTest(name = "{index} -> Авторизуемся со значением логина {0}")
    @DisplayName("Успешная авторизация")
    @ValueSource(strings = {"Test", "Тест", "_", "12345", "mail@mail.ru"})
    public void happyTest(String username) {

        String msg = driver.findElement(By.cssSelector("#loginstatus")).getText();
        assertEquals("Welcome, " + username + "!", msg);
    }

    @ParameterizedTest(name = "{index} -> Авторизуемся со значением логина {0} и пароля {1} | {argumentsWithNames}")
    @DisplayName("Авторизация")
    @MethodSource("loginAndPassProvider")
    public void tryToAuth(String login, String pass) {
        driver.findElement(By.cssSelector("[name=UserName]")).sendKeys(login);
        driver.findElement(By.cssSelector("[name=Password]")).sendKeys(pass);
        driver.findElement(By.cssSelector("#login")).click();

        String msg = driver.findElement(By.cssSelector("#loginstatus")).getText();
        assertEquals("Invalid username/password", msg);
        assertEquals("Welcome, + " + login + "!", msg);

    }
    static Stream<Arguments> loginAndPassProvider() {
        return Stream.of(
                arguments("Test", "pwd"),
                arguments("Тест", "pwd"),
                arguments("12345", "pwd"),
                arguments("mail@mail.ru", "pwd"),
                arguments("", ""),
                arguments("", "pwd"),
                arguments("Test",""),
                arguments("Test","_pwd_")
        );
    }
}
