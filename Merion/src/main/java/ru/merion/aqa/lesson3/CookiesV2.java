package ru.merion.aqa.lesson3;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class CookiesV2 {

    public static void main(String[] args) {
        // Определяем имя пользователя для сессии
        String sessionUsername = "standard_user";

        // Создаем экземпляр веб-драйвера для Chrome
        WebDriver driver = WebDriverFactory.create("chrome");
        try {
            // Открываем главную страницу демо-сайта для тестирования
            driver.get("https://www.saucedemo.com");

            // Создаём cookie для авторизации с помощью Builder паттерна
            // Указываем домен и путь для более точного управления cookie
            Cookie sessionCookie = new Cookie.Builder("session-username", sessionUsername)
                    .domain("www.saucedemo.com")  // Устанавливаем домен для cookie
                    .path("/")                    // Устанавливаем путь для cookie (корень сайта)
                    .build();

            // Добавляем созданную cookie в браузер
            driver.manage().addCookie(sessionCookie);

            // Обновляем страницу, чтобы cookie применилась и была учтена сайтом
            driver.navigate().refresh();

            // Пытаемся перейти на защищённую страницу inventory (каталог товаров)
            // Обычно эта страница доступна только авторизованным пользователям
            driver.get("https://www.saucedemo.com/inventory.html");

            // Проверяем, успешно ли мы попали на нужную страницу
            // Анализируем URL текущей страницы
            if (driver.getCurrentUrl().contains("inventory.html")) {
                // Если URL содержит "inventory.html", значит авторизация прошла успешно
                System.out.println("Успешно вошли на страницу inventory!");
            } else {
                // Если мы не на странице inventory, значит что-то пошло не так
                System.out.println("Ошибка: не удалось войти на страницу inventory.");
            }
        } catch (Exception e) {
            // Обрабатываем любые исключения, которые могут возникнуть в процессе выполнения
            System.err.println("Произошла ошибка: " + e.getMessage());
        } finally {
            // В блоке finally гарантированно закрываем браузер, даже если произошла ошибка
            // Это важно для освобождения ресурсов системы
            driver.quit();
        }
    }
}