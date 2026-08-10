package ru.merion.aqa.DZ_Praktika.Task_4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.DZ_Praktika.Task_4.page.CatalogPage;
import ru.merion.aqa.DZ_Praktika.Task_4.page.AuthPage;
import ru.merion.aqa.DZ_Praktika.Task_4.page.CartCheckoutPage;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task_4_Test {

    private WebDriver driver;

    @BeforeEach
    public void open(){
        // Общая фабрика проекта: WebDriverManager сам скачает chromedriver
        driver = WebDriverFactory.create("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterEach
    public void close(){
        if(driver != null){
            driver.quit();
        }
    }

    @Test
    public void happyPath() {
        AuthPage auth;
        CatalogPage catalog;

        Set<String> itemNames = new HashSet<>(); // из файла, по сети, из бд
        itemNames.add("Sauce Labs Backpack");
        itemNames.add("Sauce Labs Bolt T-Shirt");
        itemNames.add("Sauce Labs Onesie");

        auth = new AuthPage(driver).open();
        catalog = auth.loginAs("standard_user", "secret_sauce");
        catalog.addItems(itemNames);

        String total = new CartCheckoutPage(driver)
                .open()
                .clickCheckout()
                .setContactData("Иван", "Иванов", "123457")
                .getTotalPrice();

        // Не хардкодим сумму — цены в магазине меняются. Проверяем формат "$XX.XX".
        assertTrue(total.matches("\\$\\d+\\.\\d{2}"),
                "Ожидался итог в формате $NN.NN, получено: '" + total + "'");
    }
}