package ru.merion.aqa.lesson3;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class CookiesV2 {

    public static void main(String[] args) {
        String sessionUsername = "standard_user";

        WebDriver driver = WebDriverFactory.create("chrome");
        try {
            // Открываем главную страницу
            driver.get("https://www.saucedemo.com");

            // Создаём и добавляем куку для авторизации
            Cookie sessionCookie = new Cookie.Builder("session-username", sessionUsername)
                    .domain("www.saucedemo.com")
                    .path("/")
                    .build();
            driver.manage().addCookie(sessionCookie);

            // Обновляем страницу, чтобы кука применилась
            driver.navigate().refresh();

            // Переходим на защищённую страницу
            driver.get("https://www.saucedemo.com/inventory.html");

            // Проверяем, что мы на нужной странице (опционально)
            if (driver.getCurrentUrl().contains("inventory.html")) {
                System.out.println("Успешно вошли на страницу inventory!");
            } else {
                System.out.println("Ошибка: не удалось войти на страницу inventory.");
            }
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        } finally {
            // Закрываем браузер
            driver.quit();
        }
    }
}