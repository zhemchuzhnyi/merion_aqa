package ru.merion.aqa.practiceDZ3.Task3;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class Task3 {

    public static void main(String[] args) {
        int timeout = 45;

        WebDriver driver = WebDriverFactory.create("chrome");

        CalculatorPage calculatorPage = new CalculatorPage(driver);

        calculatorPage.open();
        calculatorPage.setDelay(timeout);
        calculatorPage.performCalculation("7", "+", "8");
        calculatorPage.waitForCalculationComplete(timeout);

        String result = calculatorPage.getResult();
        System.out.println("Результат сложения: " + result);

        driver.quit();
    }
}