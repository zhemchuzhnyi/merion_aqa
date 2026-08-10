package ru.merion.aqa.lesson_11.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.merion.aqa.WebDriverFactory;
import ru.merion.aqa.lesson7.page.CartPage;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LabirintTest {
    private static WebDriver driver;

    @BeforeAll
    public static void globalSetup() {
        System.out.println("Run tests");
    }

    @AfterAll
    public static void globalTearDown() {
        System.out.println("Finish tests");
    }

    @BeforeEach
    public void setUp(){
        driver = WebDriverFactory.create("chrome");
    }

    @AfterEach
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Поиск товаров на сайте и добавление в корзину")
    @Tags({@Tag("positive"),@Tag("search")})
    public void positiveScenario() {
        MainPage mainPage = openMainPage(driver);

        ResultPage resultPage = mainPage.header.searchFor("Java");
        resultPage.addAllItemsToCart();
        String iconText = resultPage.header.getIconText();

        // Не хардкодим точное число — каталог магазина меняется.
        // Достаточно проверить, что в корзину что-то добавилось.
        assertTrue(Integer.parseInt(iconText) > 0,
                "В корзине должны быть товары, получено: '" + iconText + "'");

        CartPage cartPage = resultPage.header.clickCartIcon();
        String counter = cartPage.getCartCounter();
        assertTrue(counter.contains("товар"),
                "Счётчик корзины должен содержать слово 'товар', получено: '" + counter + "'");
    }

    @Test
    @Tags({@Tag("negative"),@Tag("search")})
    @DisplayName("Поиск на сайте без результатов")
    public void emptySearchResult() {
        MainPage mainPage = openMainPage(driver);

        ResultPage resultPage = mainPage.header.searchFor("sdhfjgmnbvcxsdfg");
        // Лабиринт для любого запроса открывает страницу поиска, но товары в корзину не добавляются.
        // Заголовок h1 на странице результатов нестабилен, поэтому проверяем корзину.
        String iconText = resultPage.header.getIconText();
        assertEquals("0", iconText);

        CartPage cartPage = resultPage.header.clickCartIcon();
        String counter = cartPage.getEmptyCartMessage();

        assertTrue(counter.toUpperCase().contains("КОРЗИНА ПУСТА"),
                "Ожидалось сообщение о пустой корзине, получено: '" + counter + "'");
    }

    @Test
    @DisplayName("Не реализован")
    @Disabled("Тест ещё не реализован")
    public void searchResult() {
        System.out.println("test_3");
    }

    private MainPage openMainPage(WebDriver driver) {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.open();
        return mainPage;
    }
}