package ru.merion.aqa.practiceDZ3.Task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#first-name")
    private WebElement firstNameField;

    @FindBy(css = "#last-name")
    private WebElement lastNameField;

    @FindBy(css = "#postal-code")
    private WebElement postalCodeField;

    @FindBy(css = "#continue")
    private WebElement continueButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void fillCheckoutInfo(String firstName, String lastName, String postalCode) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postalCodeField.sendKeys(postalCode);
    }
    public void clickContinue() {
        continueButton.click();
    }
}
