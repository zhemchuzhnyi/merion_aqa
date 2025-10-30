package ru.merion.aqa.lesson10;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;
import ru.merion.aqa.lesson10.midlevel_page.CartPage;
import ru.merion.aqa.lesson10.midlevel_page.MainPage;
import ru.merion.aqa.lesson10.midlevel_page.ResultPage;

public class HigherLevel {
    public static void main(String[] args) {
        Configuration.baseUrl = "https://www.labirint.ru";

        // Открываем главную страницу и добавляем cookie
        MainPage mainPage = new MainPage();
        mainPage.open();

        Cookie cookie = new Cookie("cookie_policy", "1");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);

        // Повторно открываем после добавления cookie
        mainPage.open();

        // Выполняем поиск
        ResultPage resultPage = mainPage.searchFor("Java");

        // Добавляем все товары в корзину
        resultPage.addAllItemsToCart();

        // Переходим в корзину
        CartPage cartPage = resultPage.openCart();

        // Получаем цену
        String price = cartPage.getTotalPrice();
        System.out.println("Итоговая цена: " + price);

        Selenide.closeWebDriver();
    }
}

    }
}
