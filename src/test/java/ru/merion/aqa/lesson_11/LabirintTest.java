package ru.merion.aqa.lesson_11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.merion.aqa.lesson7.WDFactory;
import ru.merion.aqa.lesson7.page.CartPage;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;

public class LabirintTest {
    static WebDriver driver = null;

    public static void main(String[] args) {
        try {
            System.out.println("Начинаем проводить позитивный тест на поиск по сайту");
            driver = WDFactory.create("chrome");
            test_1(driver);
        } catch (Exception ex) {
            printExeption(ex);
        } finally {
            quitDriver();
        }

        System.out.println("\n");

        try {
            System.out.println("Начинаем проводить негативный теcт на поиск");
            driver = WDFactory.create("chrome");
            test_2(driver);
        } catch (Exception ex) {
            printExeption(ex);
        } finally {
            quitDriver();
        }
    }

    public static void test_1(WebDriver driver) {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.open();

        ResultPage resultPage = mainPage.header.searchFor("Java");
        resultPage.addAllItemsToCart();
        String iconText = resultPage.header.getIconText();
        if (iconText.equals("37")) {
            System.out.println("Проверили текст иконки");
        } else {
            System.err.println("Текст иконки не равен 37!");
        }

        CartPage cartPage = resultPage.header.clickCartIcon();
        String counter = cartPage.getCartCounter();
        if (counter.equals("37 товаров")) {
            System.out.println("Проверили текст корзины");
        } else {
            System.err.println("Счетчик в корзине не равен 37!");
        }
    }

    public static void test_2(WebDriver driver) {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.open();

        ResultPage resultPage = mainPage.header.searchFor("    @@@@   ");
        String msg = resultPage.getEmptyResultMessage();
        System.out.println(msg.equals("Мы ничего не нашли по вашему запросу! Что делать?"));

        String iconText = resultPage.header.getIconText();
        System.out.println(iconText.equals("0"));

        CartPage cartPage = resultPage.header.clickCartIcon();
        String counter = cartPage.getEmptyCartMessage();

        System.out.println(counter.equalsIgnoreCase("ВАША КОРЗИНА ПУСТА. ПОЧЕМУ?"));
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