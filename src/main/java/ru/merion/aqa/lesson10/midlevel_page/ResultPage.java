package ru.merion.aqa.lesson10.midlevel_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResultPage {

    public void addAllItemsToCart() {


        int counter = 0;
        for (WebElement card : cards) {
            card.findElement(By.cssSelector(".buy-link")).click();
            counter++;
        }

    }

}
