/*
Нажатие на кнопку

Перейти на страницу http://uitestingplayground.com/ajax
Нажать на синюю кнопку
Получить текст из зеленой плашки
Вывести его в консоль (”Data loaded with AJAX get request.”)

 */

package ru.merion.aqa.practiceDZ2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;

public class Task1 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));

        driver.get("http://uitestingplayground.com/ajax");
        driver.findElement(By.cssSelector("#ajaxButton")).click();
        String content  = driver.findElement(By.cssSelector("#content p")).getText();
        System.out.println(content);

        driver.quit();


    }
}
