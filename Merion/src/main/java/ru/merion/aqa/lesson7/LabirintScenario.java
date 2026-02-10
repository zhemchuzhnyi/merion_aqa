package ru.merion.aqa.lesson7;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.lesson7.page.CartPage;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;


public class LabirintScenario {

    public static void main(String[] args) {

        // Создаём экземпляр Chrome драйвера через фабрику
        WebDriver driver = WDFactory.create("chrome");

        // Создаём объект главной страницы и передаём в него драйвер
        MainPage mainPage = new MainPage(driver);
        // Открываем главную страницу сайта Лабиринт
        mainPage.open();

        // Выполняем поиск по ключевому слову "Java"
        ResultPage resultPage = mainPage.header.searchFor("Java");
        // Добавляем все доступные товары из результатов поиска в корзину
        resultPage.addAllItemsToCart();
        // Проверяем счётчик товаров на иконке корзины
        String iconText = resultPage.header.getIconText();
        System.out.println("iconText: " + iconText);

        // Открываем страницу корзины (кликаем по иконке корзины)
        CartPage cartPage = resultPage.header.clickCartIcon();
        // Проверяем счётчик товаров в корзине
        // Проверяем и выводим общую стоимость товаров в корзине
        String price = cartPage.getCartCounter();
        String counter = cartPage.getCartPrice();

        System.out.println("price : " + price);
        System.out.println("counter: " + counter);

        // Закрываем браузер и завершаем сессию WebDriver
        driver.quit();

    }
}