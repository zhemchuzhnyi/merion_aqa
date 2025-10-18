package ru.merion.aqa.practiceDZ3.Task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#delay")
    private WebElement delayInput;

    @FindBy(css = ".keys")
    private WebElement keyboard;

    @FindBy(css = "#spinner")
    private WebElement spinner;

    @FindBy(css = ".screen")
    private WebElement screen;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
    }

    public void setDelay(int timeout) {
        delayInput.clear();
        delayInput.sendKeys(String.valueOf(timeout));
    }

    public void clickButton(String buttonText) {
        keyboard.findElement(By.xpath("//*[text() = '" + buttonText + "']")).click();
    }

    public void waitForCalculationComplete(int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.invisibilityOf(spinner));
    }

    public String getResult() {
        return screen.getText();
    }

    public void performCalculation(String num1, String operator, String num2) {
        clickButton(num1);
        clickButton(operator);
        clickButton(num2);
        clickButton("=");
    }
}