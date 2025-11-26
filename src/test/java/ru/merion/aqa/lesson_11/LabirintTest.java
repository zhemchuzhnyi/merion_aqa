package ru.merion.aqa.lesson_11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.merion.aqa.lesson7.WDFactory;
import ru.merion.aqa.lesson7.page.CartPage;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;

import java.time.Duration;

public class LabirintTest {

    public static void main(String[] args) throws InterruptedException {
        test_1();
        test_2();
    }

    public static void test_1() throws InterruptedException {
        System.out.println("Начинаем проводить позитивный тест на поиск по сайту");
        WebDriver driver = WDFactory.create("chrome");

// Установить неявное ожидание для всех элементов
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.open();

        ResultPage resultPage = mainPage.header.searchFor("Java");
        resultPage.addAllItemsToCart();

// Небольшая пауза после добавления всех товаров
        Thread.sleep(2000); // 2 секунды

        String iconText = resultPage.header.getIconText();
        if (iconText.equals("37")){
            System.out.println("Проверили текст иконки");
        } else {
            System.err.println("Текст иконки не равен 37!");
        }

        CartPage cartPage = resultPage.header.clickCartIcon();
        Thread.sleep(3000); // 2 сек для загрузки корзины

        String counter = cartPage.getCartCounter();
        if (counter.equals("37")){
            System.out.println("Проверили текст корзины");
        } else {
            System.err.println("Счетчик в корзине не равен 37!");
        }

        driver.quit();
    }

    public static void test_2() {
        System.out.println("\nНачинаем проводить негативный тест на поиск по сайту");
        WebDriver driver = WDFactory.create("chrome");

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.open();

        ResultPage resultPage = mainPage.header.searchFor("    @@@@   ");

        String msg = resultPage.getEmptyResultMessage();
        System.out.println(msg.equals("Мы ничего не нашли по вашему запросу! Что делать?"));

        String iconText = resultPage.header.getIconText();
        System.out.println(iconText.equals("0"));

        CartPage cartPage = resultPage.header.clickCartIcon();

        String counter = cartPage.getEmptyCartMessage();

        System.out.println("counter: " + counter);
        System.out.println(counter.equalsIgnoreCase("ВАША КОРЗИНА ПУСТА. ПОЧЕМУ?"));

        driver.quit();
    }
}
