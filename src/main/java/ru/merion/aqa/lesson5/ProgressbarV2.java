/*
Прогресс бар - пример 2
 */

package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class ProgressbarV2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://uitestingplayground.com/progressbar");

        driver.findElement(By.cssSelector("#startButton")).click();

        /*
        Либо решить таким способом, но это тоже такое себе решение
        потому что можно не дождаться целевого события

        Такой тест нельзя оставить без присмотра
         */

        while (true) {
            String value = driver.findElement(By.cssSelector("#progressBar")).getAttribute("aria-valuenow");
            System.out.println(value);
            Thread.sleep(100);
            if (Integer.parseInt(value) >= 75 ) {
                driver.findElement(By.cssSelector("#stopButton")).click();
                break;
            }
        }

        System.out.println("Finished");

        driver.quit();

    }

}
