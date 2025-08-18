/*
Переход на Merion Academy
Напишите скрипт, который выполняет следующие шаги:

Открыть браузер chrome
Перейти на страницу
google.com
В строке поиска написать
Merion Academy wiki
Нажать Enter (Keys.RETURN)
На странице с результатами выбрать первую ссылку и кликнуть на нее
После перехода, получить текущий URL:
Если URL начинается со строки
https://wiki.merionet.ru
, написать
Добро пожаловать в Merion Academy!
.
Иначе написать в консоль
Мы попали куда-то не туда...
 */

package ru.merion.aqa.practiceDZ;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Task7 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");

        driver.findElement(By.cssSelector("#APjFqb")).sendKeys("Merion Academy wiki");
        driver.findElement(By.cssSelector("#APjFqb")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector("h3")).click();


        if (driver.getCurrentUrl().startsWith("https://wiki.merionet.ru")){
            System.out.println("Добро пожаловать в Merion Academy!");
        } else {
            System.out.println("Oops, мы попали куда-то не туда...((( ");
        }

        driver.quit();




    }


}
