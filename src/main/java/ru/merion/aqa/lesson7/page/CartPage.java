package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Класс представляет страницу корзины (Cart Page) на сайте.
 * Наследуется от BasePage, чтобы переиспользовать общую функциональность.
 * Реализует паттерн Page Object для работы с элементами корзины.
 */
public class CartPage extends BasePage {

    /**
     * Элемент со счётчиком количества товаров в корзине.
     * CSS селектор "#basket-default-sumprice-discount" находит элемент по id.
     * Пример текста: "3 товара" или "5 товаров"
     */
    @FindBy(css = "#basket-default-sumprice-discount")
    private WebElement productCounter;

    /**
     * Элемент с общей стоимостью всех товаров в корзине.
     * CSS селектор "#basket-default-prod-count2" находит элемент по id.
     * Пример текста: "1 250 ₽" или "3 999 ₽"
     */
    @FindBy(css = "#basket-default-prod-count2")
    private WebElement totalPrice;

    /**
     * Конструктор класса - создаёт объект страницы корзины.
     * Вызывает конструктор родительского класса BasePage,
     * который инициализирует WebDriver и элементы через PageFactory.
     *
     * @param driver - WebDriver для управления браузером
     */
    public CartPage(WebDriver driver) {
        super(driver); // Передаём driver в родительский класс для инициализации
    }

    /**
     * Метод получает количество товаров в корзине.
     *
     * @return строка с количеством товаров без лишних пробелов (например, "3 товара")
     */
    public String getCartCounter() {
        // Получаем текст из элемента счётчика
        // trim() удаляет пробелы и переносы строк в начале и конце текста
        return productCounter.getText().trim();
    }

    /**
     * Метод получает общую стоимость товаров в корзине.
     * Эта стоимость учитывает все скидки и акции.
     *
     * @return строка с итоговой ценой без лишних пробелов (например, "1 250 ₽")
     */
    public String getCartPrice() {
        // Получаем текст из элемента с общей стоимостью
        // trim() удаляет пробелы и переносы строк в начале и конце текста
        return totalPrice.getText().trim();
    }
}