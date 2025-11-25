package lesson_11;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.merion.aqa.lesson7.WDFactory;
import ru.merion.aqa.lesson7.page.CartPage;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;

public class LabirintTest_Best {
    private WebDriver driver;

    @BeforeAll
    public static void globalSetUp() {
        System.out.println("Запуск тестов");
    }

    @AfterAll
    public static void globalTearDown() {
        System.out.println("Завершение выполнения тестов");
    }

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
    @DisplayName("Позитивный тест: поиск товаров и добавление в корзину")
    @Tags({@Tag("positive"), @Tag("search")})
    public void positiveSearchTest() {
        System.out.println("Проводим позитивный тест на поиск по сайту");

        MainPage mainPage = openMainPage(driver);
        ResultPage resultPage = mainPage.header.searchFor("Java");
        resultPage.addAllItemsToCart();

        String iconText = resultPage.header.getIconText();
        Assertions.assertFalse(iconText.equals("0"), "В корзине должны быть товары");
        System.out.println("Добавлено товаров в корзину: " + iconText);

        CartPage cartPage = resultPage.header.clickCartIcon();
        String counter = cartPage.getCartCounter();
        System.out.println("Текст счетчика корзины: " + counter);
        Assertions.assertNotNull(counter, "Счетчик корзины не должен быть null");
        Assertions.assertFalse(counter.isEmpty(), "Счетчик корзины не должен быть пустым");
    }

    @Test
    @DisplayName("Негативный тест: поиск с пустым запросом")
    @Tags({@Tag("negative"), @Tag("search")})
    public void negativeSearchTest() {
        System.out.println("Проводим негативный тест на поиск");

        MainPage mainPage = openMainPage(driver);
        ResultPage resultPage = mainPage.header.searchFor("          ");

        String msg = resultPage.getEmptyResultMessage();
        Assertions.assertTrue(msg.contains("Все, что мы нашли в Лабиринте по запросу"),
                "Сообщение должно содержать текст о результатах поиска");

        resultPage.addAllItemsToCart();

        String iconText = resultPage.header.getIconText();
        Assertions.assertEquals("0", iconText, "Иконка корзины должна показывать 0");

        CartPage cartPage = resultPage.header.clickCartIcon();
        String counter = cartPage.getEmptyCartMessage();
        Assertions.assertTrue(counter.equalsIgnoreCase("ВАША КОРЗИНА ПУСТА. ПОЧЕМУ?"),
                "Сообщение о пустой корзине некорректное");
    }

    private MainPage openMainPage(WebDriver driver) {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.open();
        return mainPage;
    }
}