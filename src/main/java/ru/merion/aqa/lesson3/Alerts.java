package ru.merion.aqa.lesson3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

import java.util.List;

public class Alerts {

    public static void main(String[] args) {

        // Создаем экземпляр веб-драйвера для Chrome
        WebDriver driver = WebDriverFactory.create("chrome");

        // Переходим на страницу с JavaScript алертами
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Находим все кнопки на странице, которые вызывают алерты
        List<WebElement> buttons = driver.findElements(By.cssSelector("ul li button"));

        // Нажимаем на первую кнопку (JS Alert - простое информационное окно)
        buttons.get(0).click();
        // Переключаемся на алерт
        Alert alert = driver.switchTo().alert();
        // Получаем текст из алерта
        String text = alert.getText();
        // Принимаем алерт (нажимаем OK)
        alert.accept();

        // Нажимаем на вторую кнопку (JS Confirm - окно с подтверждением)
        buttons.get(1).click();
        // Переключаемся на алерт
        alert = driver.switchTo().alert();
        // Получаем текст из алерта
        text = alert.getText();
        // Отклоняем алерт (нажимаем Cancel)
        alert.dismiss();

        // Нажимаем на третью кнопку (JS Prompt - окно с полем для ввода)
        buttons.get(2).click();
        // Переключаемся на алерт
        alert = driver.switchTo().alert();
        // Получаем текст из алерта
        text = alert.getText();
        // Вводим текст в поле алерта
        alert.sendKeys("Hello");
        // Принимаем алерт (нажимаем OK)
        alert.accept();

        // Закрываем браузер и завершаем работу драйвера
        driver.quit();

    }

}