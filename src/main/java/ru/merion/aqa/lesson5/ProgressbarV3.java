/*
Прогресс бар
 */

package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class ProgressbarV3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://uitestingplayground.com/progressbar");

        driver.findElement(By.cssSelector("#startButton")).click();

        /*
        Явное ожидание
         */

        long timeToWait = 15 * 1000;
        Thread.sleep(100);
        long startTime = System.currentTimeMillis();

        while (true) {

            if (System.currentTimeMillis() >= startTime + timeToWait) {
                System.out.println("Не дождались исполнения условий");
                break;
            }

            String value = driver.findElement(By.cssSelector("#progressBar")).getAttribute("aria-valuenow");

            if (Integer.parseInt(value) >= 101 ) {
                driver.findElement(By.cssSelector("#stopButton")).click();
                break;
            }
        }

        System.out.println("Finished");

        driver.quit();

    }

}
