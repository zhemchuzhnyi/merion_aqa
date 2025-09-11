/*
Скрипт заполнения формы
Напишите скрипт. Шаги:

Открыть страницу https://bonigarcia.dev/selenium-webdriver-java/data-types.html

Заполнить форму значениями

Поле	Значение
First name	Иван
Last name	Петров
Address	Ленина, 55-3
Zip code	*оставить пустым
City	Москва
Country	Россия
E-mail	*оставить пустым
Phone number	*оставить пустым
Job position	QA
Company	Merion
Нажать кнопку Submit

Вывести в консоль цвет полей
Zip code
,
E-mail
 и
Phone
 (background-color)
 */
package ru.merion.aqa.practiceDZ2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class Task4 {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/data-types.html");
        driver.findElement(By.cssSelector("[name='first-name']")).sendKeys("Иван");
        driver.findElement(By.cssSelector("[name='last-name']")).sendKeys("Петров");
        driver.findElement(By.cssSelector("[name='address']")).sendKeys("Ленина, 55-3");
        driver.findElement(By.cssSelector("[name='city']")).sendKeys("Москва");
        driver.findElement(By.cssSelector("[name='country']")).sendKeys("Россия");
        driver.findElement(By.cssSelector("[name='job-position']")).sendKeys("QA");
        driver.findElement(By.cssSelector("[name='company']")).sendKeys("Merion");

        driver.findElement(By.cssSelector(".btn-outline-primary")).click();

        String color_zip = driver.findElement(By.cssSelector("#zip-code")).getCssValue("background-color");
        System.out.println("Цвет кнопки Zip code: " + color_zip);

        String color_mail = driver.findElement(By.cssSelector("#e-mail")).getCssValue("background-color");
        System.out.println("Цвет кнопки E-mail: " + color_mail);

        String color_phone = driver.findElement(By.cssSelector("#phone")).getCssValue("background-color");
        System.out.println("Цвет кнопки Phone number: " + color_phone);


        driver.quit();

    }
}
