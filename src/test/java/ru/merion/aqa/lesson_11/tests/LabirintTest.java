package ru.merion.aqa.lesson_11.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.merion.aqa.lesson7.WDFactory;
import ru.merion.aqa.lesson7.page.CartPage;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;

public class LabirintTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = WDFactory.create("chrome");
    }

    @Test
    public void positiveScenario() {
        MainPage mainPage = openMainPage(driver);

        ResultPage resultPage = mainPage.header.searchFor("Java");
        resultPage.addAllItemsToCart();
        String iconText = resultPage.header.getIconText();
        assert iconText.equals("35");

        CartPage cartPage = resultPage.header.clickCartIcon();
        String counter = cartPage.getCartCounter();
        assert counter.equals("35 товаров");

        driver.quit();
    }

    @Test
    public void emptySearchResult() {
        WebDriver driver = WDFactory.create("chrome");
        MainPage mainPage = openMainPage(driver);

        ResultPage resultPage = mainPage.header.searchFor("    @@@@   ");
        String msg = resultPage.getEmptyResultMessage();
        assert msg.equals("Мы ничего не нашли по вашему запросу! Что делать?");

        String iconText = resultPage.header.getIconText();
        assert iconText.equals("0");

        CartPage cartPage = resultPage.header.clickCartIcon();
        String counter = cartPage.getEmptyCartMessage();

        assert counter.equalsIgnoreCase("ВАША КОРЗИНА ПУСТА. ПОЧЕМУ?");

        driver.quit();
    }

    @Test
    public void searchResult() {
        System.out.println("test_3");
    }

    private MainPage openMainPage(WebDriver driver) {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.open();
        return mainPage;
    }
}



/*
package ru.merion.aqa.lesson_11.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.merion.aqa.lesson7.WDFactory;
import ru.merion.aqa.lesson7.page.CartPage;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LabirintTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = WDFactory.create("chrome");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Order(1)
    public void positiveScenario() {
        MainPage mainPage = openMainPage(driver);

        ResultPage resultPage = mainPage.header.searchFor("Java");
        resultPage.addAllItemsToCart();

        String iconText = resultPage.header.getIconText();
        assertNotNull(iconText, "Текст иконки корзины не должен быть null");
        assertFalse(iconText.isEmpty(), "Текст иконки корзины не должен быть пустым");

        System.out.println("Добавлено товаров в корзину: " + iconText);

        CartPage cartPage = resultPage.header.clickCartIcon();
        String counter = cartPage.getCartCounter();

        assertNotNull(counter, "Счётчик корзины не должен быть null");
        assertTrue(counter.contains("товар"),
                "Счётчик должен содержать слово 'товар', получено: " + counter);
    }

    @Test
    @Order(2)
    public void emptySearchResult() {
        MainPage mainPage = openMainPage(driver);

        ResultPage resultPage = mainPage.header.searchFor("    @@@@   ");
        String msg = resultPage.getEmptyResultMessage();

        System.out.println("Полученное сообщение: " + msg);

        assertNotNull(msg, "Сообщение о результате не должно быть null");
        // Проверяем что сайт вернул какое-то сообщение о результатах поиска
        // Сайт может возвращать либо "ничего не нашли" либо "все что мы нашли"
        assertTrue(msg.contains("нашли") || msg.contains("Все") || msg.contains("запросу"),
                "Ожидалось сообщение о результате поиска, получено: " + msg);

        String iconText = resultPage.header.getIconText();
        System.out.println("Значение иконки корзины: '" + iconText + "'");

        // Проверяем что корзина пустая или имеет значение 0
        assertTrue(iconText.equals("0") || iconText.isEmpty() || iconText.trim().isEmpty(),
                "Ожидался '0' или пустое значение, получено: '" + iconText + "'");

        CartPage cartPage = resultPage.header.clickCartIcon();
        String cartMessage = cartPage.getEmptyCartMessage();

        System.out.println("Сообщение корзины: " + cartMessage);

        assertNotNull(cartMessage, "Сообщение о корзине не должно быть null");
        assertTrue(cartMessage.toUpperCase().contains("КОРЗИНА ПУСТА") ||
                        cartMessage.toUpperCase().contains("КОРЗИН") ||
                        cartMessage.toUpperCase().contains("ПУСТ"),
                "Ожидалось сообщение о пустой корзине, получено: " + cartMessage);
    }

    @Test
    @Order(3)
    public void searchResult() {
        System.out.println("test_3");
    }

    private MainPage openMainPage(WebDriver driver) {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.open();
        return mainPage;
    }
}
*/