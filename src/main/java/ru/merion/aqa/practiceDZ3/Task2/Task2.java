package ru.merion.aqa.practiceDZ3.Task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Тест заполнения формы с использованием Page Object паттерна
 */
public class Task2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        // Создаем Page Object
        DataTypesPage page = new DataTypesPage(driver);

        // Выполняем тест
        page.open()
                .fillFirstName("Иван")
                .fillLastName("Петров")
                .fillAddress("Ленина, 55-3")
                .fillCity("Москва")
                .fillCountry("Россия")
                .fillJobPosition("QA")
                .fillCompany("Merion")
                .submit();

        // Проверяем цвета полей
        System.out.println("Цвет Zip Code: " + page.getZipCodeColor());
        System.out.println("Цвет E-mail: " + page.getEmailColor());
        System.out.println("Цвет Phone: " + page.getPhoneColor());

        driver.quit();
    }
}
