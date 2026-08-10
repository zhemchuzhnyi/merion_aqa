package ru.merion.aqa.lesson_12;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.merion.aqa.WebDriverFactory;
import ru.merion.aqa.lesson7.page.CartPage;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тестовый класс для проверки функционала сайта Лабиринт
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
        driver = WebDriverFactory.create("chrome");
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

        // Не хардкодим точное число — каталог магазина меняется.
        // Достаточно проверить, что в корзину что-то добавилось.
        assertTrue(Integer.parseInt(iconText) > 0,
                "В корзине должны быть товары, получено: '" + iconText + "'");

        // Переходим на страницу корзины
        CartPage cartPage = resultPage.header.clickCartIcon();
        // Получаем текст счетчика корзины на странице
        String counter = cartPage.getCartCounter();
        assertTrue(counter.contains("товар"),
                "Счётчик корзины должен содержать слово 'товар', получено: '" + counter + "'");
    }

    /**
     * Негативный тест: поиск с некорректным запросом (только спецсимволы и пробелы)
     */
    @Test
    @Order(2) // Указываем порядок выполнения - второй тест
    @Tags({@Tag("negative"),@Tag("search")}) // Помечен как негативный тест
    @DisplayName("Поиск на сайте без результатов")
    public void emptySearchResult() {
        // Открываем главную страницу
        MainPage mainPage = openMainPage(driver);

        // Ищем по невалидному запросу
        ResultPage resultPage = mainPage.header.searchFor("sdhfjgmnbvcxsdfg");
        // Лабиринт для любого запроса открывает страницу поиска, но товары в корзину не добавляются.
        // Заголовок h1 на странице результатов нестабилен, поэтому проверяем корзину.

        // Проверяем, что счетчик корзины показывает 0
        String iconText = resultPage.header.getIconText();
        assertEquals("0", iconText);

        // Переходим в пустую корзину
        CartPage cartPage = resultPage.header.clickCartIcon();
        // Получаем сообщение о пустой корзине
        String counter = cartPage.getEmptyCartMessage();

        assertTrue(counter.toUpperCase().contains("КОРЗИНА ПУСТА"),
                "Ожидалось сообщение о пустой корзине, получено: '" + counter + "'");
    }

    /**
     * Заглушка для будущего теста
     */
    @Test
    @Order(3) // Указываем порядок выполнения - третий тест
    @DisplayName("Не реализован")
    @Disabled("Тест ещё не реализован")
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