/*
Форма авторизации
Напишите скрипт, шаги:

Открыть страницу http://the-internet.herokuapp.com/login
В поле uername ввести значение
tomsmith
В поле password ввести значение
SuperSecretPassword!
Нажмите кнопку
Login
Выведите в консоль текст появившейся зеленой плашки
 */
package ru.merion.aqa.practiceDZ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

public class Task6 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://the-internet.herokuapp.com/login");
        driver.findElement(By.cssSelector("#input.username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("#input.password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.cssSelector("#button.radius")).click();




    }
}
