package ru.merion.aqa.lesson7;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;
import java.util.List;

public class LabirintScenario {

    static WebDriver driver;
    public static void main(String[] args) {
        // Создаём экземпляр Chrome драйвера через фабрику
        driver = WebDriverFactory.create("chrome");


        // Возвращаем неявное ожидание 500ms для остальных операций
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        // Находим иконку корзины со счётчиком товаров
        WebElement cartIcon = driver.findElement(By.cssSelector(".j-cart-count"));

        // Получаем и выводим количество товаров из счётчика на иконке корзины
        String cartIconCounter = cartIcon.getText();
        System.out.println("Счетчик товаров в иконке Корзине = " + cartIconCounter);

        // Кликаем по иконке корзины для перехода на страницу корзины
        cartIcon.click();

        // Находим и выводим счётчик товаров на странице корзины
        String cartCounter = driver.findElement(By.cssSelector("#basket-default-prod-count2")).getText().trim();
        System.out.println("Счетчик товаров в корзине = " + cartCounter);

        // Находим и выводим общую стоимость товаров в корзине со скидкой
        String price = driver.findElement(By.cssSelector("#basket-default-sumprice-discount")).getText().trim();
        System.out.println("Цена = " + price);

        // Закрываем браузер и завершаем сессию WebDriver
        driver.close();
    }

    public static void open () {
        // Устанавливаем неявное ожидание 500 миллисекунд для поиска элементов
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        // Открываем главную страницу Лабиринт
        driver.get("https://www.labirint.ru/");

        // Добавляем cookie для принятия политики использования cookies
        Cookie cookie = new Cookie("cookie_policy", "1");
        driver.manage().addCookie(cookie);

        // Разворачиваем окно браузера на весь экран
        driver.manage().window().maximize();

        // Перезагружаем страницу, чтобы применились cookies
        driver.get("https://www.labirint.ru/");

    }

    public static void searchFor (String term) {
        // Находим форму поиска на странице
        WebElement form = driver.findElement(By.cssSelector("#searchform"));

        // Находим поле ввода поиска и вводим текст "Java"
        form.findElement(By.cssSelector("#search-field")).sendKeys(term);

        // Отправляем форму поиска
        form.submit();
    }

    public static void addAllItemsToCart() {
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
}