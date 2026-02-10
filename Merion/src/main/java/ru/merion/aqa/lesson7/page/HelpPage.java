package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://www.labirint.ru/
public class HelpPage {
    public HelpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}