/*
Клик по кнопке
Напишите скрипт. Шаги:

Открыть страницу http://the-internet.herokuapp.com/add_remove_elements/
5 раз кликнуть на кнопку
Add Element
Собрать со страницы список кнопок
Delete
Вывести на экран размер списка
 */

package ru.merion.aqa.practiceDZ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.merion.aqa.WebDriverFactory;

import java.util.List;

public class Task1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement element = driver.findElement(By.tagName("button"));

        element.click();
        element.click();
        element.click();
        element.click();
        element.click();

//        for (int i = 0; i < 5; i ++); {
//            element.click();
//        }

        List<WebElement> deleteButtons = driver.findElements(By.className("added-manually"));

        System.out.println("Количество кнопок Delete " + deleteButtons.size());

        driver.quit();


    }
}
