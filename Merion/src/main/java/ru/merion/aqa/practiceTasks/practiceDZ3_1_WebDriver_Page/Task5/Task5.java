package ru.merion.aqa.practiceTasks.practiceDZ3_1_WebDriver_Page.Task5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task5 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        CalculatorPage calculator = new CalculatorPage(driver).open();

        calculator.setDelay(10);
        calculator.press_7();
        calculator.press_plus();
        calculator.press_8();
        calculator.press_eq();

        String result = calculator.getResult();
        System.out.println(result);

        driver.quit();
    }
}