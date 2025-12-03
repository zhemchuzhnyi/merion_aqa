package ru.merion.aqa.lesson_12;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

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

}
