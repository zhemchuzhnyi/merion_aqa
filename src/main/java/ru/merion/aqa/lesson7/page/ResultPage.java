package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class ResultPage extends BasePage {

    private static By cartIconLocator = (By.cssSelector(".j-cart-count"));

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public  void addAllItemsToCart () {

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

    public void checkEmptyResult() {
        String message = driver.findElement(By.cssSelector("h1")).getText();
        System.out.println(message);
    }
}
