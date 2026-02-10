package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

/**
 * Класс представляет страницу результатов поиска на сайте.
 * Содержит методы для работы с карточками товаров и добавления их в корзину.
 */
public class ResultPage extends BasePage {

    /**
     * Заголовок h1 с сообщением о пустых результатах поиска.
     * Отображается, когда по запросу ничего не найдено.
     */
    @FindBy(css = "h1")
    private WebElement emptyResultMessage;

    /**
     * Список элементов с текстом статуса товара (например, "Ожидается").
     * Используется для проверки доступности товара.
     */
    @FindBy(css = ".product-card__controls-text")
    private List<WebElement> controlsText; // ИСПРАВЛЕНО: было cards, теперь controlsText

    /**
     * Локатор для иконки корзины со счётчиком товаров.
     * Static т.к. не зависит от конкретного экземпляра страницы.
     */
    private static final By cartIconLocator = By.cssSelector(".j-cart-count"); // ИСПРАВЛЕНО: добавлено final

    /**
     * Конструктор класса - создаёт объект страницы результатов поиска.
     *
     * @param driver - WebDriver для управления браузером
     */
    public ResultPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Метод добавляет все доступные товары из результатов поиска в корзину.
     * Пропускает товары со статусом "Ожидается" (нет в наличии).
     */
    public void addAllItemsToCart() {
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
            List<WebElement> controlsTextElements = card.findElements(By.cssSelector(".product-card__controls-text")); // ИСПРАВЛЕНО: новая переменная

            // Если элемент найден и содержит текст "Ожидается", пропускаем этот товар
            if (!controlsTextElements.isEmpty() && controlsTextElements.get(0).getText().contains("Ожидается")) {
                // Пропускаем эту карточку и переходим к следующей
                continue;
            }

            // Ищем кнопку "Купить" (buy-link) в карточке товара
            List<WebElement> buyButtons = card.findElements(By.cssSelector(".buy-link"));

            // Если кнопка найдена, кликаем по ней для добавления товара в корзину
            if (!buyButtons.isEmpty()) {
                buyButtons.get(0).click();
                counter++; // Увеличиваем счётчик добавленных товаров
            }
        }

        // Возвращаем неявное ожидание 500ms для остальных операций
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        // Выводим количество добавленных товаров
        System.out.println("Добавлено товаров в корзину: " + counter);
    }

    /**
     * Метод получает сообщение о пустых результатах поиска.
     *
     * @return текст заголовка h1 (например, "Мы ничего не нашли по вашему запросу")
     */
    public String getEmptyResultMessage() {
        return emptyResultMessage.getText();
    }
}