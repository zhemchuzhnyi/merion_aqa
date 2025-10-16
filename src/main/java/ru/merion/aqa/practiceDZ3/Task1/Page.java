package ru.merion.aqa.practiceDZ3.Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {
    public class TextInputPage{
        private WebDriver driver;

        private By inputField = By.cssSelector(".form-control");
        private By primaryButton = By.cssSelector(".btn-primary");

        public TextInputPage(WebDriver driver) {
            this.driver = driver;
        }
        public WebElement TextInputPage open() {
            driver.get("http://uitestingplayground.com/textinput");
            return this;
        }

    }
}
