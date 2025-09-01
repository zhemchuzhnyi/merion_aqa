package ru.merion.aqa.lesson5;

import org.openqa.selenium.support.ui.WebDriverWait;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;

public class ECDemo {

    public static void main(String[] args) {
        WebDriverFactory factory = new WebDriverFactory.create();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }
}
