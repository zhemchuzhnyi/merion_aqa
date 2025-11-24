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

        //System.out.println("iconText: " + iconText);
        if (iconText.equals("37")){
            System.out.println("Проверили текст иконки");
        } else {
            System.err.println("Текст иконки не равен 60");
        }

        CartPage cartPage = resultPage.header.clickCartIcon();
        String counter = cartPage.getCartCounter();

        //System.out.println("counter: " + counter);
        System.out.println(counter.equals("37 товаров"));

        driver.quit();
    }

    public static void test2(){
        WebDriver driver = WDFactory.create("chrome");
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        ResultPage resultPage = mainPage.header.searchFor("          ");
        String msg = resultPage.getEmptyResultMessage();
        //System.out.println("msg = " + msg);

        System.out.println(msg.equals("Все, что мы нашли в Лабиринте по запросу"));
        resultPage.addAllItemsToCart();

        String iconText = resultPage.header.getIconText();
        //System.out.println("iconText: " + iconText);
        System.out.println(iconText.equals("0"));

        CartPage cartPage = resultPage.header.clickCartIcon();
        String counter = cartPage.getEmptyCartMessage();

        //System.out.println("counter: " + counter);
        System.out.println(counter.equalsIgnoreCase("ВАША КОРЗИНА ПУСТА. ПОЧЕМУ?"));

        driver.quit();
    }
}
