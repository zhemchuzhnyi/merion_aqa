package ru.merion.aqa.lesson_11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.merion.aqa.lesson7.page.CartPage;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;

public class LabirintTest {

    @Test
    public void positiveScenario(WebDriver driver) {
        MainPage mainPage = openMainPage(driver);

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

    @Test
    public void negativeTest(WebDriver driver) {
        MainPage mainPage = openMainPage(driver);

        ResultPage resultPage = mainPage.header.searchFor("    @@@@   ");
        String msg = resultPage.getEmptyResultMessage();
        System.out.println(msg.equals("Мы ничего не нашли по вашему запросу! Что делать?"));

        String iconText = resultPage.header.getIconText();
        System.out.println(iconText.equals("0"));

        CartPage cartPage = resultPage.header.clickCartIcon();
        String counter = cartPage.getEmptyCartMessage();

        System.out.println(counter.equalsIgnoreCase("ВАША КОРЗИНА ПУСТА. ПОЧЕМУ?"));
    }

    @Test
    public void emptyScenario(WebDriver driver) {
        System.out.println("Вызвали 3й тест");
    }

    private MainPage openMainPage(WebDriver driver) {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.open();

    }
}