package ru.merion.aqa.practiceDZ3_1.Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AjaxPage {

    private final WebDriver driver;

    public AjaxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://uitestingplayground.com/textinput");
    }

    public void clickTheButton(){
        driver.findElement(By.cssSelector("#ajaxButton")).click();
    }

    public String getContent() { return driver.findElement(By.cssSelector("#ajaxContent")).getText(); }

}
