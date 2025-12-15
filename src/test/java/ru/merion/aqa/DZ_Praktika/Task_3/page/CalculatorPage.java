package ru.merion.aqa.DZ_Praktika.Task_3.page;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CalculatorPage {
    private final WebDriver driver;
    public WebElement keyboard;
    private int delay = 5;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public CalculatorPage open() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        keyboard = driver.findElement(By.cssSelector(".keys"));
        return this;
    }

    public void setDelay(int delay) {
        driver.findElement(By.cssSelector("#delay")).clear();
        driver.findElement(By.cssSelector("#delay")).sendKeys(String.valueOf(delay));
        this.delay = delay;
    }

    public void press_1() {
        keyboard.findElement(By.xpath("//*[text() = '1']")).click();
    }

    public void press_2() {
        keyboard.findElement(By.xpath("//*[text() = '2']")).click();
    }

    public void press_3() {
        keyboard.findElement(By.xpath("//*[text() = '3']")).click();
    }

    public void press_4() {
        keyboard.findElement(By.xpath("//*[text() = '4']")).click();
    }

    public void press_5() {
        keyboard.findElement(By.xpath("//*[text() = '5']")).click();
    }

    public void press_6() {
        press("6");
    }

    public void press_7() {
        press("7");
    }

    public void press_8() {
        press("8");
    }

    public void press_9() {
        press("9");
    }

    public void press_plus() {
        press("+");
    }

    public void press_eq() {
        press("=");
    }

    private void press(String val) {
        keyboard.$x("*[text() = '" + val + "']").click();
    }

    public String getResult() {
        Configuration.timeout = delay * 1100;
        $("#spinner").shouldBe(not(visible));
        return $(".screen").text();
    }

}
