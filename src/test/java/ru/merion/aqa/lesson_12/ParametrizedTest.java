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
    public void unauthorized1() {
        driver.findElement(By.cssSelector("[name=UserName]")).sendKeys("");
        driver.findElement(By.cssSelector("[name=Password]")).sendKeys("");
        driver.findElement(By.cssSelector("#login")).click();

        String msg = driver.findElement(By.cssSelector("#loginstatus")).getText();
        assertEquals("Invalid username/password", msg);
    }

    public void unauthorized2() {
        driver.findElement(By.cssSelector("[name=UserName]")).sendKeys("");
        driver.findElement(By.cssSelector("[name=Password]")).sendKeys("pwd");
        driver.findElement(By.cssSelector("#login")).click();

        String msg = driver.findElement(By.cssSelector("#loginstatus")).getText();
        assertEquals("Invalid username/password", msg);
    }

    public void unauthorized3() {
        driver.findElement(By.cssSelector("[name=UserName]")).sendKeys("Test");
        driver.findElement(By.cssSelector("[name=Password]")).sendKeys("");
        driver.findElement(By.cssSelector("#login")).click();

        String msg = driver.findElement(By.cssSelector("#loginstatus")).getText();
        assertEquals("Invalid username/password", msg);
    }

    public void unauthorized() {
        driver.findElement(By.cssSelector("[name=UserName]")).sendKeys("Test");
        driver.findElement(By.cssSelector("[name=Password]")).sendKeys("_pwd_");
        driver.findElement(By.cssSelector("#login")).click();

        String msg = driver.findElement(By.cssSelector("#loginstatus")).getText();
        assertEquals("Invalid username/password", msg);
    }
}
