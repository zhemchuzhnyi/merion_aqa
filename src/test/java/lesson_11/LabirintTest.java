package lesson_11;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.lesson7.WDFactory;
import ru.merion.aqa.lesson7.page.CartPage;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;

public class LabirintTest {

    public static void main(String[] args) {

        WebDriver driver = WDFactory.create("chrome");

        MainPage mainPage = new MainPage(driver);

        mainPage.open();


        ResultPage resultPage = mainPage.header.searchFor("Java");

        resultPage.addAllItemsToCart();

        String iconText = resultPage.header.getIconText();
        System.out.println("iconText: " + iconText);

        CartPage cartPage = resultPage.header.clickCartIcon();

        String price = cartPage.getCartCounter();
        String counter = cartPage.getCartPrice();

        System.out.println("price : " + price);
        System.out.println("counter: " + counter);

        driver.quit();

    }
}
