package ru.merion.aqa.practiceDZ3.Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Переименовать кнопку
 *
 * Напишите скрипт. Шаги:
 *
 * Перейти на сайт http://uitestingplayground.com/textinput
 * Указать в поле ввода текст "Merion"
 * Нажать на синюю кнопку
 * Получить текст кнопки и вывести в консоль (Merion)
 */

// TODO - переделать в PageObject

public class Task1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        TextInputPage textInputPage = new TextInputPage(driver);
        String buttonText = textInputPage

        System.out.println(buttonText);

        driver.quit();


    }
}
