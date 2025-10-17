package ru.merion.aqa.practiceDZ3.Task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DataTypesPage {

    private WebDriver driver;

    // Локаторы
    private By firstNameField = By.cssSelector("[name = 'first-name']");
    private By lastNameField = By.cssSelector("[name = 'last-name']");
    private By addressField = By.cssSelector("[name = 'address']");
    private By cityField = By.cssSelector("[name = 'city']");
    private By countryField = By.cssSelector("[name = 'country']");
    private By jobPositionField = By.cssSelector("[name = 'job-position']");
    private By companyField = By.cssSelector("[name = 'company']");
    private By submitButton = By.cssSelector(".btn-outline-primary");



}
