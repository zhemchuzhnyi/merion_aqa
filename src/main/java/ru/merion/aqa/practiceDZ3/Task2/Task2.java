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

        DataTypesPage page = new DataTypesPage(driver);

        page.open()
                .fillFirstName("Иван")
                        .fillLastName("Петров")
                                .fillAddress("Ленина, 55-3")
                                        .fillCity("Москва")
                                                .fillCountry("Россия")
                                                        .fillJobPosition("QA")
                                                                .fillCompany("Merion");

        System.out.println();
        System.out.println();
        System.out.println();

        driver.quit();

    }
}
