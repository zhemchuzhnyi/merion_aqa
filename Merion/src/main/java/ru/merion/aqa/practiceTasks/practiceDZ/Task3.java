/*
Клик по кнопке с css-классом
Напишите скрипт. Шаги:

Открыть страницу http://uitestingplayground.com/classattr
Кликнуть на синюю(!) кнопку
Запустите скрипт 3 раза. Убедитесь, что код не требуется редактировать – скрипт всегда работает.
 */

package ru.merion.aqa.practiceTasks.practiceDZ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

public class Task3 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://uitestingplayground.com/classattr");
        WebElement element = driver.findElement(By.cssSelector(".btn.btn-primary"));
        element.click();

        driver.quit();
    }
}
