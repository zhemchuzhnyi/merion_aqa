package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected final WebDriver driver;

    public HeaderElement header;

    protected BasePage (WebDriver driver) {
        this.driver = driver;
        WebElement header = driver.findElement(By.cssSelector(".b-header-b-logo"));
        this.header = PageFactory.initElements(driver, HeaderElement.class);
    }


}
