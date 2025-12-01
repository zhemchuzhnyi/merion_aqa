package ru.merion.aqa.lesson_11.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import ru.merion.aqa.lesson7.page.CartPage;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;

public class LabirintTest {
    @Test
    public void positiveScenario() {
        WebDriver driver = new ChromeDriver();
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
        assert counter.equals("37 товаров");
    }

    private MainPage openMainPage(WebDriver driver) {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.open();
        return mainPage;
    }
}
