package ru.merion.aqa.practiceDZ3.Task1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.merion.aqa.practiceDZ3.Task1.pages.TextInputPage;

import java.time.Duration;

/**
 * Переименовать кнопку (версия с Page Object)
 *
 * Напишите скрипт. Шаги:
 *
 * Перейти на сайт http://uitestingplayground.com/textinput
 * Указать в поле ввода текст "Merion"
 * Нажать на синюю кнопку
 * Получить текст кнопки и вывести в консоль (Merion)
 */

public class Task1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        TextInputPage textInputPage = new TextInputPage(driver);

        String buttonText = textInputPage
                .open()
                .enterText("Merion")
                .clickButton()
                .getButtonText();

        System.out.println(buttonText);

        driver.quit();
    }
}