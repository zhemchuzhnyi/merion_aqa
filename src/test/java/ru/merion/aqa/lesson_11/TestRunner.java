package ru.merion.aqa.lesson_11;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.lesson7.WDFactory;

public class TestRunner {
    static WebDriver driver = null;

    public static void main(String[] args) {
        System.out.println("Run Tests");

    LabirintTest testClass = new LabirintTest();
        try {
            System.out.println("Начинаем проводить позитивный тест на поиск по сайту");
            driver = WDFactory.create("chrome");
            testClass.test_1(driver);
        } catch (Exception ex) {
            printExeption(ex);
        } finally {
            quitDriver();
        }

        System.out.println("\n");

        try {
            System.out.println("Начинаем проводить негативный теcт на поиск");
            driver = WDFactory.create("chrome");
            testClass.test_2(driver);
        } catch (Exception ex) {
            printExeption(ex);
        } finally {
            quitDriver();
        }
    }

    private static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    private static void printExeption(Exception ex) {
        System.err.println("Тест упал");
        System.err.println(ex);
    }
}
