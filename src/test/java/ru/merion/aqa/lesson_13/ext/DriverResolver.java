package ru.merion.aqa.lesson_13.ext;

import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class DriverResolver implements ParameterResolver, BeforeAllCallback, AfterAllCallback {

    private static WebDriver driver;

    @Override
    public void beforeAll(ExtensionContext context) {
        driver = WebDriverFactory.create("chrome");
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return parameterContext.getParameter().getType() == WebDriver.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return driver;
    }

    @Override
    public void afterAll(ExtensionContext context) {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
