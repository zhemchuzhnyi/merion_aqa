package ru.merion.aqa.DZ_Praktika.Task_1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.merion.aqa.DZ_Praktika.Task_1.page.TextInputPage;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 Переименовать кнопку

 Напишите скрипт. Шаги:

 Перейти на сайт http://uitestingplayground.com/textinput
 Указать в поле ввода текст "Merion"
 Нажать на синюю кнопку
 Проверьте, что текст кнопки = Merion
 **/

public class Task_1_Test {
    private static final String BUTTON_NAME = "Merion";
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
}
