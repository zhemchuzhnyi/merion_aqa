package ru.merion.aqa.lesson_12;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    @Test
    public void happyPath() {
        String username = "Test";
        driver.findElement(By.cssSelector("[name=UserName]")).sendKeys("username");
        driver.findElement(By.cssSelector("[name=Password]")).sendKeys("pwd");
        driver.findElement(By.cssSelector("#login")).click();

        String msg = driver.findElement(By.cssSelector("#loginstatus")).getText();
        assertEquals("Welcome, " + username + "!", msg);
    }
}
