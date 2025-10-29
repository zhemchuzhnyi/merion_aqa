package ru.merion.aqa.lesson10;
import com.codeborne.selenide.Selenide;
import ru.merion.aqa.lesson10.midlevel_page.CartPage;
import ru.merion.aqa.lesson10.midlevel_page.MainPage;
import ru.merion.aqa.lesson10.midlevel_page.ResultPage;
import static com.codeborne.selenide.Selenide.*;

public class NoEncapsulation {
    public static void main(String[] args) {

        MainPage main = new MainPage();
        main.open();
        main.searchFor("Java");

        ResultPage resultPage = new ResultPage();
        resultPage.addAllItemsToCart();


        CartPage cartPage = new CartPage();
        String price = cartPage.getCartPrice().text();
        System.out.println(price);

        Selenide.closeWebDriver();
    }
}
