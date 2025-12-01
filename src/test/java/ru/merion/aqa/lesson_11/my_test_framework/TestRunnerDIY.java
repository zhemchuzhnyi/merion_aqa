package ru.merion.aqa.lesson_11.my_test_framework;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.lesson7.WDFactory;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class TestRunnerDIY {
    static WebDriver driver = null;

    public static void main(String[] args) {
        System.out.println("Run Tests");

        LabirintTestDIY testClass = new LabirintTestDIY();
        Method [] methods = testClass.getClass().getDeclaredMethods();
        int testsTotal = 0;
        Set<Method> success = new HashSet<>();
        Set<Method> failure = new HashSet<>();

        for (Method testMethod : methods) {
            try {
                if (testMethod.isAnnotationPresent(Test.class)) {
                    testsTotal++;
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println(testMethod.getName());
                    driver = WDFactory.create("chrome");
                    testMethod.invoke(testClass, driver);
                    success.add(testMethod);

                }
            } catch (Exception ex) {
                failure.add(testMethod);
                printException(ex);
            } finally {
                quitDriver();
            }
        }
        System.out.println("testsTotal: " + testsTotal);
        System.out.println("success: " + success.size());
        System.out.println("failure: " + failure.size());
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