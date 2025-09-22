package ru.merion.aqa.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

    public static void main(String[] args) {
        // Создаем экземпляр драйвера Chrome для автоматизации браузера
        WebDriver driver = new ChromeDriver();

        // Открываем веб-приложение JS Paint с предзагруженным изображением
        driver.get("https://jspaint.app/#local:f027a292cdf1");

        // Находим основной элемент холста для рисования
        WebElement canvas = driver.findElement(By.cssSelector(".main-canvas"));

        // Находим панель инструментов
        WebElement tools = driver.findElement(By.cssSelector(".tools"));

        // Находим инструмент "Кисть" по атрибуту title
        WebElement brush = tools.findElement(By.cssSelector("[title='Кисть']"));

        // Находим инструмент "Заливка" по атрибуту title
        WebElement paint = tools.findElement(By.cssSelector("[title = 'Заливка']"));

        // Находим инструмент "Прямоугольник" по атрибуту title
        WebElement rect = tools.findElement(By.cssSelector("[title='Прямоугольник']"));

        // Находим цвет (голубой) в палитре по значению RGB
        WebElement color = driver.findElement(By.cssSelector("[data-color = 'rgb(128,128,255)']"));

        // Устанавливаем паузу в 1 секунду между действиями для визуализации
        long pause = 1000l;

        // Рисуем квадрат кистью с помощью chain of actions
        new Actions(driver)
                .click(brush)              // Выбираем инструмент кисть
                .clickAndHold(canvas)      // зажимает кнопку мыши на холсте
                .pause(pause)              // Пауза для визуализации
                .moveByOffset(0, -150)     // Рисуем линию вверх
                .pause(pause)              // Пауза для визуализации
                .moveByOffset(150,0)       // Рисуем линию вправо
                .pause(pause)              // Пауза для визуализации
                .moveByOffset(0,150)       // Рисуем линию вниз
                .pause(pause)              // Пауза для визуализации
                .moveByOffset(-150,0)      // Рисуем линию влево (замыкаем квадрат)
                .release(canvas)           // Отпускаем кнопку мыши
                .perform();                // Выполняем всю цепочку действий

        // Перемещаем курсор в другое место (не обязательно для следующих действий)
        new Actions(driver)
                .moveByOffset(-100,100)    // Смещаем курсор на 100px влево и 100px вниз
                .perform(); // перемещаем курсор

        // Заливаем нарисованный квадрат выбранным цветом
        new Actions(driver)
                .click(paint)                    // Выбираем инструмент заливки
                .click(color)                    // Выбираем голубой цвет
                .moveToElement(canvas, 10,-10)   // Перемещаемся к определенной точке на холсте (смещение от центра)
                .click()                         // Кликаем для заливки
                .perform();                      // Выполняем действия

        // Рисуем прямоугольник с зажатой клавишей Shift (для создания квадрата)
        new Actions(driver)
                .click(rect)                     // Выбираем инструмент прямоугольник
                .moveToElement(canvas)           // Перемещаемся к холсту
                .keyDown(Keys.LEFT_SHIFT)        // Зажимаем левый Shift (для создания правильной геометрической фигуры)
                .clickAndHold()                  // Начинаем рисование прямоугольника (зажимаем кнопку мыши)
                .moveByOffset(-300, 150)         // Перетаскиваем для создания прямоугольника
                .release()                       // Отпускаем кнопку мыши
                .keyUp(Keys.LEFT_SHIFT)          // Отпускаем клавишу Shift
                .perform();                      // Выполняем действия

        // Закрываем браузер и завершаем работу драйвера
        driver.quit();
    }
}