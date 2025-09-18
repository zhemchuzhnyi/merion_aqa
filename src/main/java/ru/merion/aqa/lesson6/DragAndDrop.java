package ru.merion.aqa.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DragAndDrop {

    public static void main(String[] args) {
        String token = "eyJraWQiOiJzZXNzaW9uLXNlcnZpY2UvcHJvZC0xNzM4Nzk0ODc0IiwiYWxnIjoiUlMyNTYifQ.eyJhc3NvY2lhdGlvbnMiOltdLCJzdWIiOiI3MTIwMjA6YzQwOThjMmUtNmZhZC00OGEzLTg5ZDMtZmFmYzA5MzM1MGU5IiwiZW1haWxEb21haW4iOiJnbWFpbC5jb20iLCJpbXBlcnNvbmF0aW9uIjpbXSwiY3JlYXRlZCI6MTc1ODIzMTg0OCwicmVmcmVzaFRpbWVvdXQiOjE3NTgyMzI1MzMsInZlcmlmaWVkIjp0cnVlLCJpc3MiOiJzZXNzaW9uLXNlcnZpY2UiLCJzZXNzaW9uSWQiOiIwZDJmMTA3MC0xZjI1LTRiNzgtYWVlYi02YjQxMmFjOGQ0YmYiLCJzdGVwVXBzIjpbXSwiYXVkIjoiYXRsYXNzaWFuIiwibmJmIjoxNzU4MjMxOTMzLCJleHAiOjE3NjA4MjM5MzMsImlhdCI6MTc1ODIzMTkzMywiZW1haWwiOiJhcmVzaGtpbi5vbmRyZXlAZ21haWwuY29tIiwianRpIjoiMGQyZjEwNzAtMWYyNS00Yjc4LWFlZWItNmI0MTJhYzhkNGJmIn0.hNmKjKjLYeCpdw5HwPufNCslvxESLsaYtZKZv5gQzS3iMy-epUiGBkdo-LZS51NdDZhQVBdgOtGpcG9O0KL2bgu8JmiS9Fl8b4OFwai9E9qWmFL-TkRc05285LnjO5aoPwtEdbTLeW7xvwJXgxjwXU1TJUToMZZ4EyLR-FKfPDJUK9r3LIeN9PhEVAIfHVav6qbO51QaC1yEtSUgQtP8Qz8l6BBe6HKpnNMdKVv_2OlmrzU26wkigp5lmW1Oim_ePGSkfEteHfSacc3wO8Ik-OSHekufKxOm0azSZx9FMYCLGUVCfOa-msp1ImKf9vSFNt6b78lQVVYUkLn8bpg65g";

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://trello.com");
        driver.manage().addCookie(new Cookie("cloud.session.token", token));
        driver.get("https://trello.com/b/esQuklgl/test");

        List<WebElement> columns = driver.findElements(By.cssSelector("li[data-testid=list-wrapper]"));
        List<WebElement> cards = columns.get(0).findElements(By.cssSelector("li[data-testid=list-cards]"));



        driver.quit();

    }
}
