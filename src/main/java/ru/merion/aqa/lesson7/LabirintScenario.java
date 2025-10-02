package ru.merion.aqa.lesson7;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;
import ru.merion.aqa.lesson7.page.CartPage;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;


public class LabirintScenario {

    public static void main(String[] args) {

        // Создаём экземпляр Chrome драйвера через фабрику
        WebDriver driver = WebDriverFactory.create("chrome");

        // Создаём объект главной страницы и передаём в него драйвер
        MainPage mainPage = new MainPage(driver);
        // Открываем главную страницу сайта Лабиринт
        mainPage.open();
        // Выполняем поиск по ключевому слову "Java"
        mainPage.searchFor("Java");

        // Создаём объект страницы результатов поиска
        ResultPage resultPage = new ResultPage(driver);
        // Добавляем все доступные товары из результатов поиска в корзину
        resultPage.addAllItemsToCart();
        // Проверяем счётчик товаров на иконке корзины
        resultPage.checkIconText();

        // Создаём объект страницы корзины
        CartPage cartPage = new CartPage(driver);
        // Открываем страницу корзины (кликаем по иконке корзины)
        cartPage.open();
        // Проверяем и выводим количество товаров в корзине
        cartPage.checkCartCounter();
        // Проверяем и выводим общую стоимость товаров в корзине
        cartPage.checkCartPrice();

        // Закрываем браузер и завершаем сессию WebDriver
        driver.quit();

    }
}