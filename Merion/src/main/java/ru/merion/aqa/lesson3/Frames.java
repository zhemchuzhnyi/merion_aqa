package ru.merion.aqa.lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

import java.util.List;

public class Frames {

    public static void main(String[] args) {

        // Создаем экземпляр веб-драйвера для Chrome
        WebDriver driver = WebDriverFactory.create("chrome");

        // Переходим на страницу с вложенными фреймами (nested frames)
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // Пытаемся найти элементы body на основной странице (вне фреймов)
        // На этой странице основной контент находится во фреймах, поэтому список должен быть пустым
        List<WebElement> shouldBeEmpty = driver.findElements(By.cssSelector("body"));

        // Переключаемся на нижний фрейм по его имени "frame-bottom"
        // После переключения все последующие команды будут выполняться внутри этого фрейма
        driver.switchTo().frame("frame-bottom");

        // Теперь ищем элементы body внутри фрейма "frame-bottom"
        // Здесь уже должен быть найден элемент body с содержимым
        List<WebElement> shouldHaveBody = driver.findElements(By.cssSelector("body"));

        // Выводим текст из body элемента нижнего фрейма
        // Это покажет содержимое, которое находится внутри frame-bottom
        System.out.println(shouldHaveBody.get(0).getText());

        // Закрываем браузер и завершаем работу драйвера
        driver.quit();

    }
}