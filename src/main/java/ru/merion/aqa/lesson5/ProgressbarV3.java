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

        long timeToWait = 15 * 1000;
        long startTime = System.currentTimeMillis();
        long finishTime = startTime + timeToWait;

        while (true) {

            if (System.currentTimeMillis() >= finishTime) {
                System.out.println("Не дождались исполнения условий");
                break;
            }
            String value = driver.findElement(By.cssSelector("#progressBar")).getAttribute("aria-valuenow");
            System.out.println(value);
            Thread.sleep(100);
            if (Integer.parseInt(value) >= 101 ) {
                driver.findElement(By.cssSelector("#stopButton")).click();
                break;
            }
        }

        System.out.println("Finished");

        driver.quit();

    }

}
