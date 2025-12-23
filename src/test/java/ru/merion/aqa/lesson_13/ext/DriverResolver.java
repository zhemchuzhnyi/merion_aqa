package ru.merion.aqa.lesson_13.ext;

import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class DriverResolver implements ParameterResolver, AfterAllCallback {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return true;
    }

    private WebDriver driver;
    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        driver = WebDriverFactory.create("chrome");
        return driver;
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
