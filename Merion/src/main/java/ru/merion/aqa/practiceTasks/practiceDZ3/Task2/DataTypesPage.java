package ru.merion.aqa.practiceTasks.practiceDZ3.Task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Page Object для страницы с формой Data Types
public class DataTypesPage {
    private WebDriver driver;

    // Локаторы полей формы
    private By firstNameField = By.cssSelector("[name='first-name']");
    private By lastNameField = By.cssSelector("[name='last-name']");
    private By addressField = By.cssSelector("[name='address']");
    private By cityField = By.cssSelector("[name='city']");
    private By countryField = By.cssSelector("[name='country']");
    private By jobPositionField = By.cssSelector("[name='job-position']");
    private By companyField = By.cssSelector("[name='company']");
    private By submitButton = By.cssSelector(".btn-outline-primary");

    // Локаторы для проверки цвета
    private By zipCodeResult = By.cssSelector("#zip-code");
    private By emailResult = By.cssSelector("#e-mail");
    private By phoneResult = By.cssSelector("#phone");

    public DataTypesPage(WebDriver driver) {
        this.driver = driver;
    }

    //Открыть страницу
    public DataTypesPage open() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/data-types.html");
        return this;
    }

    //Заполнить поля
    public DataTypesPage fillFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
        return this;
    }

    public DataTypesPage fillLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public DataTypesPage fillAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
        return this;
    }

    public DataTypesPage fillCity(String city) {
        driver.findElement(cityField).sendKeys(city);
        return this;
    }

    public DataTypesPage fillCountry(String country) {
        driver.findElement(countryField).sendKeys(country);
        return this;
    }

    public DataTypesPage fillJobPosition(String jobPosition) {
        driver.findElement(jobPositionField).sendKeys(jobPosition);
        return this;
    }

    public DataTypesPage fillCompany(String company) {
        driver.findElement(companyField).sendKeys(company);
        return this;
    }

    //Нажать кнопку Submit
    public void submit() {
        driver.findElement(submitButton).click();
    }

    //Получить цвет полей
    public String getZipCodeColor() {
        return driver.findElement(zipCodeResult).getCssValue("background-color");
    }

    public String getEmailColor() {
        return driver.findElement(emailResult).getCssValue("background-color");
    }

    public String getPhoneColor() {
        return driver.findElement(phoneResult).getCssValue("background-color");
    }


    /* удобный метод - заполняет поля разом
     public DataTypesPage fillForm(String firstName, String lastName, String address,
                                  String city, String country, String jobPosition, String company) {
        fillFirstName(firstName);
        fillLastName(lastName);
        fillAddress(address);
        fillCity(city);
        fillCountry(country);
        fillJobPosition(jobPosition);
        fillCompany(company);
        return this;
     */

}