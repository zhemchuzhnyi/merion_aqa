package ru.merion.aqa.lesson_12;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.merion.aqa.lesson7.WDFactory;
import ru.merion.aqa.lesson7.page.CartPage;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тестовый класс для проверки функционала сайта Лабиринт
 * Содержит автотесты для поиска товаров и работы с корзиной
 *
 * Тесты запускаются в порядке их объявления в классе (сверху вниз)
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Включаем упорядочивание тестов
public class LabirintTest {
    // Статическая переменная драйвера для использования во всех тестах
    private static WebDriver driver;

    /**
     * Метод выполняется один раз ПЕРЕД всеми тестами в классе
     * Используется для глобальной настройки (например, подготовка тестовых данных)
     */
    @BeforeAll
    public static void globalSetup() {
        System.out.println("Run tests");
    }

    /**
     * Метод выполняется один раз ПОСЛЕ всех тестов в классе
     * Используется для глобальной очистки ресурсов
     */
    @AfterAll
    public static void globalTearDown() {
        System.out.println("Finish tests");
    }

    /**
     * Метод выполняется ПЕРЕД КАЖДЫМ тестом
     * Инициализирует новый экземпляр браузера для изоляции тестов
     */
    @BeforeEach
    public void setUp(){
        // Создаем новый экземпляр Chrome драйвера через фабрику
        driver = WDFactory.create("chrome");
    }

    /**
     * Метод выполняется ПОСЛЕ КАЖДОГО теста
     * Закрывает браузер и освобождает ресурсы
     */
    @AfterEach
    public void tearDown(){
        // Проверяем, что драйвер инициализирован, перед закрытием
        if (driver != null) {
            driver.quit(); // Закрываем браузер и завершаем сессию WebDriver
        }
    }

    /**
     * Позитивный тест: поиск товаров по запросу "Java" и добавление всех в корзину
     * Запускается первым
     */
    @Test
    @Order(1) // Указываем порядок выполнения - первый тест
    @DisplayName("Поиск товаров на сайте и добавление в корзину")
    @Tags({@Tag("positive"),@Tag("search")}) // Теги для группировки и фильтрации тестов
    public void positiveScenario() {
        // Открываем главную страницу сайта
        MainPage mainPage = openMainPage(driver);

        // Выполняем поиск по запросу "Java"
        ResultPage resultPage = mainPage.header.searchFor("Java");
        // Добавляем все найденные товары в корзину
        resultPage.addAllItemsToCart();
        // Получаем текст счетчика товаров на иконке корзины
        String iconText = resultPage.header.getIconText();

        // Проверяем, что в корзине 35 товаров
        // assertEquals(ожидаемое, фактическое) - стандартный порядок в JUnit
        assertEquals("35", iconText);

        // Переходим на страницу корзины
        CartPage cartPage = resultPage.header.clickCartIcon();
        // Получаем текст счетчика корзины на странице
        String counter = cartPage.getCartCounter();
        // Проверяем полный текст счетчика
        assertEquals("35 товаров", counter);
    }

    /**
     * Негативный тест: поиск с некорректным запросом (только спецсимволы и пробелы)
     * Запускается вторым
     */
    @Test
    @Order(2) // Указываем порядок выполнения - второй тест
    @Tags({@Tag("negative"),@Tag("search")}) // Помечен как негативный тест
    @DisplayName("Поиск на сайте без результатов")
    public void emptySearchResult() {
        // Открываем главную страницу
        MainPage mainPage = openMainPage(driver);

        // Ищем по невалидному запросу (спецсимволы и пробелы)
        ResultPage resultPage = mainPage.header.searchFor("    @@@@   ");
        // Получаем сообщение о пустом результате
        String msg = resultPage.getEmptyResultMessage();

        // Проверяем текст сообщения об отсутствии результатов
        assertEquals("Все, что мы нашли в Лабиринте по запросу «@@@@»", msg);

        // Проверяем, что счетчик корзины показывает 0
        String iconText = resultPage.header.getIconText();
        assertEquals("0", iconText);

        // Переходим в пустую корзину
        CartPage cartPage = resultPage.header.clickCartIcon();
        // Получаем сообщение о пустой корзине
        String counter = cartPage.getEmptyCartMessage();

        // Приводим к верхнему регистру для сравнения
        // (на случай, если на сайте регистр может меняться)
        assertEquals("ВАША КОРЗИНА ПУСТА. ПОЧЕМУ?", counter.toUpperCase());
    }

    /**
     * Заглушка для будущего теста
     * Помечен как отключенный, чтобы не ломать прогон тестов
     * Запускался бы третьим, если бы не был отключен
     */
    @Test
    @Order(3) // Указываем порядок выполнения - третий тест
    @DisplayName("Не реализован")
    //@Disabled("Тест еще не реализован") // Тест будет пропущен при запуске
    public void searchResult() {
        System.out.println("test_3");
    }

    /**
     * Вспомогательный метод для открытия главной страницы
     * @param driver - экземпляр WebDriver
     * @return объект MainPage для дальнейшей работы с элементами страницы
     */
    private MainPage openMainPage(WebDriver driver) {
        // Инициализируем Page Object через PageFactory
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        // Открываем главную страницу
        mainPage.open();
        return mainPage;
    }
}



/*
package ru.merion.aqa.lesson_11.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.merion.aqa.lesson7.WDFactory;
import ru.merion.aqa.lesson7.page.CartPage;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LabirintTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = WDFactory.create("chrome");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Order(1)
    public void positiveScenario() {
        MainPage mainPage = openMainPage(driver);

        ResultPage resultPage = mainPage.header.searchFor("Java");
        resultPage.addAllItemsToCart();

        String iconText = resultPage.header.getIconText();
        assertNotNull(iconText, "Текст иконки корзины не должен быть null");
        assertFalse(iconText.isEmpty(), "Текст иконки корзины не должен быть пустым");

        System.out.println("Добавлено товаров в корзину: " + iconText);

        CartPage cartPage = resultPage.header.clickCartIcon();
        String counter = cartPage.getCartCounter();

        assertNotNull(counter, "Счётчик корзины не должен быть null");
        assertTrue(counter.contains("товар"),
                "Счётчик должен содержать слово 'товар', получено: " + counter);
    }

    @Test
    @Order(2)
    public void emptySearchResult() {
        MainPage mainPage = openMainPage(driver);

        ResultPage resultPage = mainPage.header.searchFor("    @@@@   ");
        String msg = resultPage.getEmptyResultMessage();

        System.out.println("Полученное сообщение: " + msg);

        assertNotNull(msg, "Сообщение о результате не должно быть null");
        // Проверяем что сайт вернул какое-то сообщение о результатах поиска
        // Сайт может возвращать либо "ничего не нашли" либо "все что мы нашли"
        assertTrue(msg.contains("нашли") || msg.contains("Все") || msg.contains("запросу"),
                "Ожидалось сообщение о результате поиска, получено: " + msg);

        String iconText = resultPage.header.getIconText();
        System.out.println("Значение иконки корзины: '" + iconText + "'");

        // Проверяем что корзина пустая или имеет значение 0
        assertTrue(iconText.equals("0") || iconText.isEmpty() || iconText.trim().isEmpty(),
                "Ожидался '0' или пустое значение, получено: '" + iconText + "'");

        CartPage cartPage = resultPage.header.clickCartIcon();
        String cartMessage = cartPage.getEmptyCartMessage();

        System.out.println("Сообщение корзины: " + cartMessage);

        assertNotNull(cartMessage, "Сообщение о корзине не должно быть null");
        assertTrue(cartMessage.toUpperCase().contains("КОРЗИНА ПУСТА") ||
                        cartMessage.toUpperCase().contains("КОРЗИН") ||
                        cartMessage.toUpperCase().contains("ПУСТ"),
                "Ожидалось сообщение о пустой корзине, получено: " + cartMessage);
    }

    @Test
    @Order(3)
    public void searchResult() {
        System.out.println("test_3");
    }

    private MainPage openMainPage(WebDriver driver) {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.open();
        return mainPage;
    }
}
*/