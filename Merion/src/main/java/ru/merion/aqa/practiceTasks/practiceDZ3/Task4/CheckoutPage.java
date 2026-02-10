package ru.merion.aqa.practiceTasks.practiceDZ3.Task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    private By firstNameField = By.cssSelector("#first-name");
    private By lastNameField = By.cssSelector("#last-name");
    private By postalCodeField = By.cssSelector("#postal-code");
    private By continueButton = By.cssSelector("#continue");
    private By totalLabel = By.cssSelector(".summary_total_label");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillPersonalInfo(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public String getTotalAmount() {
        return driver.findElement(totalLabel).getText();
    }
}