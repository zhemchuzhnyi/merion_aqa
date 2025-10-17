package ru.merion.aqa.practiceDZ3.Task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DataTypesPage {

    private WebDriver driver;

    // Локаторы
    private By firstNameField = By.cssSelector("[name = 'first-name']");
    private By lastNameField = By.cssSelector("[name = 'last-name']");

}
