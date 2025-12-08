package ru.merion.aqa.lesson_12.ext;

import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

import java.lang.reflect.Field;
import java.util.Optional;

public class BeforeAndAfterEachCallbacks implements BeforeEachCallback, AfterEachCallback {

    private WebDriver driver = null;

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println("Начинаем выполнять");
        Optional<Object> testInstance = context.getTestInstance();
        if (testInstance.isPresent() && testInstance.get().getClass().isAnnotationPresent(InjectWebDriver.class)) {
            driver = WebDriverFactory.create("chrome");

            // Используем рефлексию для установки driver в любой тестовый класс
            try {
                Field driverField = testInstance.get().getClass().getField("driver");
                driverField.setAccessible(true);
                driverField.set(testInstance.get(), driver);
            } catch (NoSuchFieldException e) {
                System.err.println("Поле driver не найдено в классе " + testInstance.get().getClass().getName());
            }
        }
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println("Закончили выполнять");
        if (this.driver != null) {
            driver.quit();
            driver = null;
        }
    }
}