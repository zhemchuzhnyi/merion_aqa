package ru.merion.aqa.lesson7;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;

import java.time.Duration;
import java.util.List;


public class LabirintScenario {

    public static WebDriver driver;
    private static By cartIconLocator = (By.cssSelector(".j-cart-count"));

    public static void main(String[] args) {

        // Создаём экземпляр Chrome драйвера через фабрику
        WebDriver driver = WebDriverFactory.create("chrome");

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.searchFor("Java");

        ResultPage resultPage = new ResultPage(driver);

        addAllItemsToCart();
        checkIconText();
        openCart();
        checkCartCounter();
        checkCartPrice();

        // Закрываем браузер и завершаем сессию WebDriver
        driver.close();
    }

    public static void addAllItemsToCart () {

        int counter = 0;
        // Отключаем неявное ожидание для быстрой проверки элементов в цикле
        // Это критично для производительности, чтобы не ждать 500ms на каждый несуществующий элемент
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(0));

        // Получаем список всех карточек товаров на странице результатов поиска
        List<WebElement> cards = driver.findElements(By.cssSelector(".product-card"));

        // Проходим по каждой карточке товара
        for (WebElement card : cards) {
            // Проверяем, есть ли в карточке элемент с классом product-card__controls-text
            // Этот элемент появляется у товаров со статусом "Ожидается"
            List<WebElement> controlsText = card.findElements(By.cssSelector(".product-card__controls-text"));
            if (!controlsText.isEmpty() && controlsText.get(0).getText().contains("Ожидается")) {
                // Пропускаем эту карточку и переходим к следующей
                continue;
            }

            // Ищем кнопку "Купить" (buy-link) в карточке товара
            List<WebElement> buyButtons = card.findElements(By.cssSelector(".buy-link"));

            // Если кнопка найдена, кликаем по ней для добавления товара в корзину
            if (!buyButtons.isEmpty()) {
                buyButtons.get(0).click();
                counter++;
            }
        }

        // Возвращаем неявное ожидание 500ms для остальных операций
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        // Находим иконку корзины со счётчиком товаров
        WebElement cartIcon = driver.findElement(By.cssSelector(".j-cart-count"));

        // Выводим количество добавленных товаров
        System.out.println("Добавлено товаров в корзину: " + counter);
    }

    public static void checkIconText() {

        // Получаем и выводим количество товаров из счётчика на иконке корзины
        String cartIconCounter = driver.findElement(cartIconLocator).getText();
        System.out.println("Счетчик товаров в иконке Корзине = " + cartIconCounter);
    }

    public static void openCart() {

        // Кликаем по иконке корзины для перехода на страницу корзины
        driver.findElement(cartIconLocator).click();
    }
    public static void checkCartCounter () {

        // Находим и выводим счётчик товаров на странице корзины
        String cartCounter = driver.findElement(By.cssSelector("#basket-default-prod-count2")).getText().trim();
        System.out.println("Счетчик товаров в корзине = " + cartCounter);
    }

    public static void checkCartPrice () {

        // Находим и выводим общую стоимость товаров в корзине со скидкой
        String price = driver.findElement(By.cssSelector("#basket-default-sumprice-discount")).getText().trim();
        System.out.println("Цена = " + price);
    }
}