package ru.merion.aqa.DZ_Praktika.Task_2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.merion.aqa.DZ_Praktika.Task_2.page.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
 * Проверьте, что поля
 * Zip code
 * ,
 * E-mail
 *  и
 * Phone
 *  выделены красным (background-color)
 */

public class Task_2_Test {
    private WebDriver driver;

    @BeforeEach
    public void open() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void checkValidatorError() {
        RegisterPage page = new RegisterPage(driver).open();

        page.set("first-name", "Иван");
        page.set("last-name", "Иванов");
        page.set("job-position", "QA");
        page.set("address", "Ленина 55-3");
        page.set("city", "Москва");
        page.set("country", "Россия");
        page.set("company","Merion");

        page.submitForm();

        String phone_bg = page.getCssProperty("#phone", "background-color");
        String email_bg = page.getCssProperty("#e-mail", "background-color");
        String zip_code_bg = page.getCssProperty("#zip-code", "background-color");

        assertEquals("rgba(248, 215, 218, 1)", zip_code_bg);
        assertEquals("rgba(248, 215, 218, 1)", email_bg);
        assertEquals("rgba(248, 215, 218, 1)", phone_bg);
    }



}
