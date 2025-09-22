package ru.merion.aqa.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.Keys.*;

public class KeyboardActions {

    public static void main(String[] args) {
        // Создаем экземпляр драйвера Chrome для автоматизации браузера
        WebDriver driver = new ChromeDriver();

        // Открываем тестовую страницу с полем ввода текста
        driver.get("http://uitestingplayground.com/textinput");

        // Определяем локатор для поля ввода с ID "newButtonName"
        By locator = By.cssSelector("#newButtonName");

        // Определяем правильную клавишу для копирования в зависимости от операционной системы
        // На Mac используется CMD, на Windows/Linux - CTRL
        Keys cmdCtrl = Platform.getCurrent().is(Platform.MAC) ? COMMAND : CONTROL;

        // Устанавливаем паузу в 1 секунду между действиями для визуализации
        long pause = 1000L;

        // Выполняем цепочку клавиатурных действий
        new Actions(driver)
                .keyDown(LEFT_SHIFT)                               // Зажимаем левую клавишу Shift
                .sendKeys(driver.findElement(locator), "merion")   // Вводим текст "merion" в поле (с зажатым Shift для заглавных букв)
                .keyUp(LEFT_SHIFT)                                 // Отпускаем левую клавишу Shift
                .pause(pause)                                      // Пауза для визуализации
                .keyDown(LEFT_SHIFT)                               // Снова зажимаем левую клавишу Shift
                .sendKeys(ARROW_UP)                                // Нажимаем стрелку вверх с зажатым Shift (выделение текста вверх)
                .keyUp(LEFT_SHIFT)                                 // Отпускаем левую клавишу Shift
                .keyDown(cmdCtrl)                                  // Зажимаем клавишу Ctrl (или Cmd на Mac)
                .sendKeys("c")                                     // Нажимаем "c" для копирования (Ctrl+C или Cmd+C)
                .pause(pause)                                      // Пауза для визуализации
                .sendKeys("vv")                                    // Вставляем текст дважды (Ctrl+V или Cmd+V два раза)
                .pause(pause)                                      // Пауза для визуализации
                .sendKeys("v")                                     // Еще одна вставка (Ctrl+V или Cmd+V)
                .keyUp(cmdCtrl)                                    // Отпускаем клавишу Ctrl (или Cmd на Mac)
                .pause(pause)                                      // Финальная пауза для визуализации
                .perform();                                        // Выполняем всю цепочку действий

        // Закрываем браузер и завершаем работу драйвера
        driver.quit();
    }
}