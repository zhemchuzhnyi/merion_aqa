package ru.merion.aqa.lesson10;
import com.codeborne.selenide.Selenide;
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

        String price = $("#basket-default-sumprice-discount").text();
        System.out.println(price);

        Selenide.closeWebDriver();
    }
}
