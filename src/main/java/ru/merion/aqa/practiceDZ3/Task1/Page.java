package ru.merion.aqa.practiceDZ3.Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page {
    public class TextInputPage{
        private WebDriver driver;

        private By inputField = By.ByCssSelector(".form-control");
        private By primaryButton = By.cssSelector(".btn-primary");

    }
}
