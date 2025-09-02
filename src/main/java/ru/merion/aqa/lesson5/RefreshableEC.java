package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Function;

public class RefreshableEC {

    public static ExpectedCondition<WebElement> textContains(By locator, String textContain ) {
        return new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                driver.navigate().refresh();
                WebElement element = driver.findElement(locator);
                String text = element.getText();
                boolean contains = text.contains(textContain);

                // delete
                if (text.isEmpty() || text.isBlank()) {
                    System.out.println("<ПУСТО>");
                } else {
                    System.out.println(text);
                }
                return null;
            }

            public String toString() {
                return "Элемент с локатором " + locator + " содержит текст " + textContain;
            }
        };
    }
}
