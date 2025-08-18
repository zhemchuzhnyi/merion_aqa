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

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://the-internet.herokuapp.com/inputs");
        driver.findElement(By.cssSelector("input")).sendKeys("1000");
        Thread.sleep(3000);
        driver.navigate().refresh();
        driver.findElement(By.cssSelector("input")).clear();
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input")).sendKeys("2000");


        driver.quit();
    }

}
