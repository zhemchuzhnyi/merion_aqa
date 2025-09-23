package ru.merion.aqa.lesson3;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;
import java.util.Set;

public class CookiesV3 {

    public static void main(String[] args) {
        // Создаем экземпляр веб-драйвера для Chrome
        WebDriver driver = WebDriverFactory.create("chrome");

        // Открываем главную страницу системы обучения Merionet
        driver.get("https://lms.merionet.ru");

        // Создаем и добавляем cookie с ID сессии Moodle для авторизации
        // MoodleSession - это системная cookie, которая содержит идентификатор сессии пользователя
        Cookie cookie = new Cookie("MoodleSession", "da8k3stv0052052efj1p4t0pn4");
        driver.manage().addCookie(cookie);

        // Обновляем страницу, чтобы добавленная cookie вступила в силу
        // После обновления система должна распознать пользователя как авторизованного
        driver.navigate().refresh();

        // Переходим на страницу личного кабинета пользователя
        // Эта страница обычно доступна только авторизованным пользователям
        driver.get("https://lms.merionet.ru/my/");

        // Получаем все cookies, установленные в текущем браузере для данного домена
        Set<Cookie> cookies = driver.manage().getCookies();

        // Получаем конкретную cookie по имени "MoodleSession" для дальнейшего использования
        // Это может быть полезно для проверки того, что cookie была корректно установлена
        Cookie MoodleSession = driver.manage().getCookieNamed("MoodleSession");

        // Закрываем браузер и завершаем работу драйвера
        driver.quit();
    }
}