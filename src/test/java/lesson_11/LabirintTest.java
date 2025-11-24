package lesson_11;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.lesson7.WDFactory;
import ru.merion.aqa.lesson7.page.CartPage;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;

public class LabirintTest {

    public static void main(String[] args) {
        test1();
        test2();
    }
    public static void test1(){
        WebDriver driver = WDFactory.create("chrome");

        MainPage mainPage = new MainPage(driver);

        mainPage.open();


        ResultPage resultPage = mainPage.header.searchFor("Java");

        resultPage.addAllItemsToCart();

        String iconText = resultPage.header.getIconText();
        System.out.println("iconText: " + iconText);

        CartPage cartPage = resultPage.header.clickCartIcon();
        String counter = cartPage.getCartPrice();

        System.out.println("counter: " + counter);

        driver.quit();
    }

    public static void test2(){
        WebDriver driver = WDFactory.create("chrome");

        MainPage mainPage = new MainPage(driver);

        mainPage.open();


        ResultPage resultPage = mainPage.header.searchFor("jfjkskhahk943029480923");
        String msg = resultPage.getEmptyResultMessage();
        System.out.println("msg = " + msg);

        resultPage.addAllItemsToCart();

        String iconText = resultPage.header.getIconText();
        System.out.println("iconText: " + iconText);

        CartPage cartPage = resultPage.header.clickCartIcon();
        String counter = cartPage.getCartPrice();

        System.out.println("counter: " + counter);

        driver.quit();
    }
}
