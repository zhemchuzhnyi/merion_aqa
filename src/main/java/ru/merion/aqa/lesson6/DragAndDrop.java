package ru.merion.aqa.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class DragAndDrop {
    public static void main(String[] args) {
        String token = "eyJraWQiOiJzZXNzaW9uLXNlcnZpY2UvcHJvZC0xNzM4Nzk0ODc0IiwiYWxnIjoiUlMyNTYifQ.eyJhc3NvY2lhdGlvbnMiOltdLCJzdWIiOiI3MTIwMjA6YzQwOThjMmUtNmZhZC00OGEzLTg5ZDMtZmFmYzA5MzM1MGU5IiwiZW1haWxEb21haW4iOiJnbWFpbC5jb20iLCJpbXBlcnNvbmF0aW9uIjpbXSwiY3JlYXRlZCI6MTc1ODIzMzcwNywicmVmcmVzaFRpbWVvdXQiOjE3NTgyMzQ3MDAsInZlcmlmaWVkIjp0cnVlLCJpc3MiOiJzZXNzaW9uLXNlcnZpY2UiLCJzZXNzaW9uSWQiOiJlODZlMzJhNi0yYTVjLTRmNWEtYWFhZS1jMDdlZGQ0NTM4ZTEiLCJzdGVwVXBzIjpbXSwiYXVkIjoiYXRsYXNzaWFuIiwibmJmIjoxNzU4MjM0MTAwLCJleHAiOjE3NjA4MjYxMDAsImlhdCI6MTc1ODIzNDEwMCwiZW1haWwiOiJhcmVzaGtpbi5vbmRyZXlAZ21haWwuY29tIiwianRpIjoiZTg2ZTMyYTYtMmE1Yy00ZjVhLWFhYWUtYzA3ZWRkNDUzOGUxIn0.HE6EYJJJA11i0ot4iFknkiSzcSzD2eTDoeAB_xoxfLRh8USGlmmZyX2AROCa9eqoC0lt5lkbaj5HPBvNAuDlwYV2TmWqD0KeV4pSsJwB8LY-zXBDbx6i27eXTVJBcyG5ImmH2FpzW5DCldxFxq4Nuq-SxHw3WgnWkZmmXTJPVtAjNoOMemaEfRScSq-aTIAIktdoW3x4w-oQpJpeI4PBQ7n_wjKfVUzDAICCWL7y72I2HIjxRKnz5TKAtvfjRTt-l0OTN6sEI_kLsQ6SCgzRLHBRZyJOjc5WjQ3q2KRJWxp3z4zIH4ALy6o510T3eBixIWGC5NIppPYiZ-LPpZfOPQ";

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            driver.get("https://trello.com");
            driver.manage().addCookie(new Cookie("cloud.session.token", token));
            driver.get("https://trello.com/b/esQuklgl/test");

            // Ожидание загрузки колонок
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("li[data-testid=list-wrapper]")));

            List<WebElement> columns = driver.findElements(By.cssSelector("li[data-testid=list-wrapper]"));

            // Ожидание загрузки карточек в первой колонке
            WebElement firstColumn = columns.get(0);
            wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
                    firstColumn, By.cssSelector("li[data-testid=list-card]")));

            List<WebElement> cards = firstColumn.findElements(By.cssSelector("li[data-testid=list-card]"));

            // Находим область для drop в целевой колонке
            WebElement targetColumn = columns.get(2);
            WebElement dropArea = targetColumn.findElement(By.cssSelector("ol[data-testid=list-cards]"));

            // Выполняем drag and drop
            new Actions(driver)
                    .clickAndHold(cards.get(0))
                    .pause(Duration.ofMillis(500))
                    .moveToElement(dropArea)
                    .pause(Duration.ofMillis(500))
                    .release()
                    .perform();

            // Ожидание завершения операции
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}