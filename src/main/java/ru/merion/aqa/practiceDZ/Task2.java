/*
Клик по кнопке без id
Напишите скрипт. Шаги:

Открыть страницу http://uitestingplayground.com/dynamicid
Кликнуть на синюю кнопку
Запустите скрипт 3 раза. Убедитесь, что код не требуется редактировать – скрипт всегда работает.
 */

package ru.merion.aqa.practiceDZ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.merion.aqa.WebDriverFactory;

public class Task2 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestingplayground.com/dynamicid");
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.quit();

    }
}
