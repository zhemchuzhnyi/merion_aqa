package ru.merion.aqa.lesson_13;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.merion.aqa.lesson7.WDFactory;
import ru.merion.aqa.lesson7.page.CartPage;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LabirintTest {

    @Test
    @Order(1)
    @DisplayName("Поиск товаров на сайте и добавление в корзину")
    @Tags({@Tag("positive"),@Tag("search")})
    public void positiveScenario(WebDriver driver) {
        MainPage mainPage = openMainPage(driver);
        ResultPage resultPage = mainPage.header.searchFor("Java");
        resultPage.addAllItemsToCart();
        String iconText = resultPage.header.getIconText();
        assertEquals("35", iconText);
        CartPage cartPage = resultPage.header.clickCartIcon();
        String counter = cartPage.getCartCounter();
        assertEquals("35 товаров", counter);
    }

    @Test
    @Order(2)
    @Tags({@Tag("negative"),@Tag("search")})
    @DisplayName("Поиск на сайте без результатов")
    public void emptySearchResult(WebDriver driver) {
        MainPage mainPage = openMainPage(driver);
        ResultPage resultPage = mainPage.header.searchFor("    @@@@   ");
        String msg = resultPage.getEmptyResultMessage();
        assertEquals("Все, что мы нашли в Лабиринте по запросу «@@@@»", msg);
        String iconText = resultPage.header.getIconText();
        assertEquals("0", iconText);
        CartPage cartPage = resultPage.header.clickCartIcon();
        String counter = cartPage.getEmptyCartMessage();
        assertEquals("ВАША КОРЗИНА ПУСТА. ПОЧЕМУ?", counter.toUpperCase());
    }

    @Test
    @Order(3)
    @DisplayName("Не реализован")
    public void searchResult() {
        System.out.println("test_3");
    }

    private MainPage openMainPage(WebDriver driver) {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.open();
        return mainPage;
    }
}