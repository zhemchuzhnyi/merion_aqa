package ru.merion.aqa.lesson_13.ext;

import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

/**
 * Внедряет WebDriver в параметры тестов и управляет его жизненным циклом:
 * новый браузер на каждый тест (BeforeEach/AfterEach), без общих статических полей.
 * Драйвер хранится в ExtensionContext.Store, что безопасно и для параллельных прогонов.
 */
public class DriverResolver implements ParameterResolver, BeforeEachCallback, AfterEachCallback {

    private static final ExtensionContext.Namespace NS =
            ExtensionContext.Namespace.create(DriverResolver.class);
    private static final String DRIVER_KEY = "webdriver";

    @Override
    public void beforeEach(ExtensionContext context) {
        context.getStore(NS).put(DRIVER_KEY, WebDriverFactory.create("chrome"));
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return parameterContext.getParameter().getType() == WebDriver.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return extensionContext.getStore(NS).get(DRIVER_KEY, WebDriver.class);
    }

    @Override
    public void afterEach(ExtensionContext context) {
        WebDriver driver = context.getStore(NS).remove(DRIVER_KEY, WebDriver.class);
        if (driver != null) {
            driver.quit();
        }
    }
}