package ru.merion.aqa.lesson_11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.merion.aqa.lesson7.WDFactory;
import ru.merion.aqa.lesson7.page.CartPage;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;

public class LabirintTest {

    public static void main(String[] args) {
        test_1();
        test_2();
    }

    public static void test_1() {
        // Создаём экземпляр Chrome драйвера через фабрику
        WebDriver driver = WDFactory.create("chrome");

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.open();

        ResultPage resultPage = mainPage.header.searchFor("Java");

        resultPage.addAllItemsToCart();

        String iconText = resultPage.header.getIconText();
        System.out.println(iconText.equals("37"));

        CartPage cartPage = resultPage.header.clickCartIcon();

        String price = cartPage.getCartCounter();
        String counter = cartPage.getCartPrice();

        System.out.println("price : " + price);
        System.out.println(counter.equals("37 товаров"));

        driver.quit();
    }

    public static void test_2() {
        WebDriver driver = WDFactory.create("chrome");

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.open();

        ResultPage resultPage = mainPage.header.searchFor("    @@@@   ");

        String msg = resultPage.getEmptyResultMessage();
        System.out.println("msg: " + msg);

        String iconText = resultPage.header.getIconText();
        System.out.println("iconText: " + iconText);

        CartPage cartPage = resultPage.header.clickCartIcon();

        String counter = cartPage.getEmptyCartMessage();

        System.out.println("counter: " + counter);

        driver.quit();
    }
}
