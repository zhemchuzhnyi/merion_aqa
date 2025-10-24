package ru.merion.aqa.lesson9;

import com.codeborne.selenide.*;
import org.openqa.selenium.Cookie;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeLessThanOrEqual;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ElementsCollectionDemo {
    public static void main(String[] args) {

        // Открываем главную страницу сайта
        open("https://www.labirint.ru/");

        // Добавляем cookie для принятия политики куки
        Cookie cookie = new Cookie("cookie_policy", "1");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);

        // Перезагружаем страницу с установленным cookie
        open("https://www.labirint.ru/");

        // Вводим "Java" в поле поиска и нажимаем Enter
        $("#search-field").val("Java").pressEnter();

        // Собираем все карточки товаров (не больше 60)
        ElementsCollection cards = $$(".product-card")
                .shouldHave(sizeLessThanOrEqual(60));

        // Извлекаем атрибуты data-product-id со всех карточек
        List<String> attributeValues = cards.attributes("data-product-id");

        // Фильтруем только книги с упоминанием "JavaScript"
        List<String> jsBooks = cards.filter(Condition.text("JavaScript")).texts();

        // Исключаем книги с упоминанием "JavaScript" (остаются только Java)
        List<String> javaBooks = cards.exclude(Condition.text("JavaScript")).texts();
        System.out.println(javaBooks.size());

        // Способ 1: прямой сбор текстов названий (быстрый)
        long start = System.currentTimeMillis();
        List<String> names = $$(".product-card .product-card__name").texts();
        System.out.println(System.currentTimeMillis() - start);

        // Способ 2: сбор через stream с проверкой существования (медленный)
        start = System.currentTimeMillis();
        List<String> strings = cards.asFixedIterable().stream()
                .map(card -> card.find(".product-card__name"))
                .filter(element -> element.exists())
                .map(element -> element.text())
                .toList();
        System.out.println(System.currentTimeMillis() - start);

        // Закрываем браузер
        Selenide.closeWebDriver();
    }
}