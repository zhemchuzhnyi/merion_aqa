package ru.merion.aqa.lesson_11;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.lesson7.WDFactory;

import java.lang.reflect.Method;

public class TestRunner {
    static WebDriver driver = null;

    public static void main(String[] args) {
        System.out.println("Run Tests");

        LabirintTest testClass = new LabirintTest();
        Method [] methods = testClass.getClass().getMethods();

        for (Method testMethod : methods) {
            try {
                if (testMethod.isAnnotationPresent(Test.class)) {
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println(testMethod.getName());
                    driver = WDFactory.create("chrome");
                    testMethod.invoke(testClass, driver);

                }
            } catch (Exception ex) {
                printException(ex);
            } finally {
                quitDriver();
            }
        }
    }

    private static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    private static void printException(Exception ex) {
        System.err.println("Тест упал");
        System.err.println(ex);
    }
}