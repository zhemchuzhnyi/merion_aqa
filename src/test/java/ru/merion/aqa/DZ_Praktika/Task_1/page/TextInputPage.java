package ru.merion.aqa.DZ_Praktika.Task_1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextInputPage {
    private final WebDriver driver;

    public TextInputPage(WebDriver driver) {
        this.driver = driver;
    }

    public TextInputPage open() {
        driver.get("http://uitestingplayground.com/textinput");
        return this;
    }
    public TextInputPage setButtonName(String name) {
        driver.findElement(By.cssSelector("#newButtonName")).sendKeys(name);
        driver.findElement(By.cssSelector("#updatingButton")).click();
        return this;
    }
    public String getButtonText() {
        return driver.findElement(By.cssSelector("#updatingButton")).getText();
    }
}
