/*
Модальное окно
Напишите скрипт. Шаги:

Открыть страницуhttp://the-internet.herokuapp.com/entry_ad
В модальном окне нажать на кнопку
Сlose
Выведите в консоль текст элемента с
id = content
Подсказка: тут вам может понадобиться
Thread.sleep(3000);
 */
package ru.merion.aqa.practiceTasks.practiceDZ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.merion.aqa.WebDriverFactory;

import java.util.List;

public class Task4 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/entry_ad");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector(".modal-footer")).click();

        String content = driver.findElement(By.cssSelector("#content")).getText();

        System.out.println("Текст элемента: " + content);

        driver.quit();


    }

}
