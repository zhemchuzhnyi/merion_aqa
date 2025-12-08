package ru.merion.aqa.lesson_12.ext;

import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;
import java.lang.reflect.Field;

public class WebDriverInjector implements BeforeEachCallback, AfterEachCallback {

    private WebDriver driver = null;

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        Object testInstance = context.getTestInstance().get();
        if (testInstance.getClass().isAnnotationPresent(InjectWebDriver.class)) {
            Field[] fields = testInstance.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getType().equals(WebDriver.class)) {
                    boolean before = field.canAccess(testInstance);
                    field.setAccessible(true);
                    driver = WebDriverFactory.create("chrome");
                    field.set(testInstance, driver);
                    field.setAccessible(before);
                }
            }
        }
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        if (this.driver != null) {
            driver.quit();
            driver = null;
        }
    }
}