/*
Переименовать кнопку
Напишите скрипт. Шаги:

Перейти на сайт http://uitestingplayground.com/textinput
Указать в поле ввода текст "Merion"
Нажать на синюю кнопку
Получить текст кнопки и вывести в консоль (Merion)
 */

package ru.merion.aqa.practiceDZ2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class Task2 {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://uitestingplayground.com/textinput");

        driver.findElement(By.cssSelector("#newButtonName")).sendKeys("Merion");
        driver.findElement(By.cssSelector("#updatingButton")).click();
        String content = driver.findElement(By.cssSelector("#updatingButton")).getText();
        System.out.println("Текст кнопки: " + content);

        driver.quit();


    }
}
