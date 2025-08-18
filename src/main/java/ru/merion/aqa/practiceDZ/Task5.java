/*
Поле ввода
Напишите скрипт. Шаги:

http://the-internet.herokuapp.com/inputs
Введите в поле текст
1000
Очистите это поле (метод
clear
)
введите в это же поле текст
2000
 */
package ru.merion.aqa.practiceDZ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

public class Task5 {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement element = driver.findElement(By.cssSelector("input"));

        driver.quit();
    }

}
