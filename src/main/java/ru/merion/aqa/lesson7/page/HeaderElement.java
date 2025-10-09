package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Класс представляет шапку (header) сайта - верхнюю часть страницы с поиском и корзиной.
 * Реализует паттерн Page Object для работы с элементами header'а.
 */
public class HeaderElement {
    // Хранит ссылку на WebDriver для взаимодействия с браузером
    private final WebDriver driver;

    // Аннотация @FindBy указывает Selenium, как найти элемент на странице
    // CSS селектор "#searchform" находит форму поиска по её id
    @FindBy(css = "#searchform")
    private WebElement form;

    // CSS селектор "#search-field" находит поле ввода для поиска по его id
    @FindBy(css = "#search-field")
    private WebElement seachField;

    // CSS селектор ".j-cart-count" находит иконку корзины со счётчиком товаров по классу
    @FindBy(css = ".j-cart-count")
    private WebElement cartIcon;

    /**
     * Конструктор класса - создаёт объект HeaderElement.
     * @param driver - WebDriver для управления браузером
     */
    public HeaderElement(WebDriver driver) {
        this.driver = driver;
        // PageFactory инициализирует все элементы, помеченные @FindBy
        // ОШИБКА: должно быть initElements(driver, this), а не HeaderElement.class
        PageFactory.initElements(driver, this);
    }

    /**
     * Метод выполняет поиск на сайте.
     * @param term - текст для поиска (например, "Java")
     * @return объект ResultPage - страницу с результатами поиска
     */
    public ResultPage searchFor(String term) {
        // Вводим текст поиска в поле ввода
        seachField.sendKeys(term);

        // Отправляем форму (аналог нажатия Enter или кнопки "Искать")
        form.submit();

        // Создаём и возвращаем объект страницы с результатами
        return new ResultPage(driver);
    }

    /**
     * Метод получает текст из счётчика корзины.
     * @return количество товаров в корзине в виде строки (например, "3")
     */
    public String getIconText() {
        // Получаем текст из элемента (число товаров в корзине)
        return cartIcon.getText();
    }

    /**
     * Метод кликает по иконке корзины для перехода на страницу корзины.
     * @return объект CartPage - страницу корзины
     */
    public CartPage clickCartIcon() {
        // Выполняем клик по иконке корзины
        cartIcon.click();

        // Создаём и возвращаем объект страницы корзины
        return new CartPage(driver);
    }
}