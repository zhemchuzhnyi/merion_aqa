package ru.merion.aqa.practiceDZ3.Task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Скрипт заполнения формы
 *
 * Напишите скрипт. Шаги:
 *
 * Открыть страницу https://bonigarcia.dev/selenium-webdriver-java/data-types.html
 *
 * Заполнить форму значениями
 *
 * Поле	Значение
 * First name	Иван
 * Last name	Петров
 * Address	Ленина, 55-3
 * Zip code	*оставить пустым
 * City	Москва
 * Country	Россия
 * E-mail	*оставить пустым
 * Phone number	*оставить пустым
 * Job position	QA
 * Company	Merion
 * Нажать кнопку Submit
 *
 * Вывести в консоль цвет полей
 * Zip code
 * ,
 * E-mail
 *  и
 * Phone
 *  (background-color)
 */

// TODO - переделать в PageObject

public class Task2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/data-types.html");
        driver.findElement(By.cssSelector("[name = 'first-name']")).sendKeys("Иван");
        driver.findElement(By.cssSelector("[name = 'last-name']")).sendKeys("Петров");
        driver.findElement(By.cssSelector("[name = 'address']")).sendKeys("Ленина, 55-3");
        driver.findElement(By.cssSelector("[name = 'city']")).sendKeys("Москва");
        driver.findElement(By.cssSelector("[name = 'country']")).sendKeys("Россия");
        driver.findElement(By.cssSelector("[name = 'job-position']")).sendKeys("QA");
        driver.findElement(By.cssSelector("[name = 'company']")).sendKeys("Merion");

        driver.findElement(By.cssSelector(".btn-outline-primary")).click();

        driver.findElement(By.cssSelector("#zip-code")).getCssValue("background-color");



        driver.quit();


    }
}
