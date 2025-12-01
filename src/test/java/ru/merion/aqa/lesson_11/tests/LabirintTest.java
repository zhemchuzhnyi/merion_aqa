package ru.merion.aqa.lesson_11.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.merion.aqa.lesson7.WDFactory;
import ru.merion.aqa.lesson7.page.CartPage;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;

public class LabirintTest {
    @Test
    public void positiveScenario() {
        WebDriver driver = WDFactory.create("chrome");
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
        System.out.println(iconText.equals("0"));

        CartPage cartPage = resultPage.header.clickCartIcon();
        String counter = cartPage.getEmptyCartMessage();

        assert counter.equalsIgnoreCase("ВАША КОРЗИНА ПУСТА. ПОЧЕМУ?");
    }

    private MainPage openMainPage(WebDriver driver) {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.open();
        return mainPage;
    }
}
