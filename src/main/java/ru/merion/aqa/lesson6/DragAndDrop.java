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
        // JWT токен для аутентификации в Trello (содержит информацию о сессии пользователя)
        String token = "eyJraWQiOiJzZXNzaW9uLXNlcnZpY2UvcHJvZC0xNzM4Nzk0ODc0IiwiYWxnIjoiUlMyNTYifQ.eyJhc3NvY2lhdGlvbnMiOltdLCJzdWIiOiI3MTIwMjA6YzQwOThjMmUtNmZhZC00OGEzLTg5ZDMtZmFmYzA5MzM1MGU5IiwiZW1haWxEb21haW4iOiJnbWFpbC5jb20iLCJpbXBlcnNvbmF0aW9uIjpbXSwiY3JlYXRlZCI6MTc1ODIzMzcwNywicmVmcmVzaFRpbWVvdXQiOjE3NTgyMzQ3MDAsInZlcmlmaWVkIjp0cnVlLCJpc3MiOiJzZXNzaW9uLXNlcnZpY2UiLCJzZXNzaW9uSWQiOiJlODZlMzJhNi0yYTVjLTRmNWEtYWFhZS1jMDdlZGQ0NTM4ZTEiLCJzdGVwVXBzIjpbXSwiYXVkIjoiYXRsYXNzaWFuIiwibmJmIjoxNzU4MjM0MTAwLCJleHAiOjE3NjA4MjYxMDAsImlhdCI6MTc1ODIzNDEwMCwiZW1haWwiOiJhcmVzaGtpbi5vbmRyZXlAZ21haWwuY29tIiwianRpIjoiZTg2ZTMyYTYtMmE1Yy00ZjVhLWFhYWUtYzA3ZWRkNDUzOGUxIn0.HE6EYJJJA11i0ot4iFknkiSzcSzD2eTDoeAB_xoxfLRh8USGlmmZyX2AROCa9eqoC0lt5lkbaj5HPBvNAuDlwYV2TmWqD0KeV4pSsJwB8LY-zXBDbx6i27eXTVJBcyG5ImmH2FpzW5DCldxFxq4Nuq-SxHw3WgnWkZmmXTJPVtAjNoOMemaEfRScSq-aTIAIktdoW3x4w-oQpJpeI4PBQ7n_wjKfVUzDAICCWL7y72I2HIjxRKnz5TKAtvfjRTt-l0OTN6sEI_kLsQ6SCgzRLHBRZyJOjc5WjQ3q2KRJWxp3z4zIH4ALy6o510T3eBixIWGC5NIppPYiZ-LPpZfOPQ";

        // Создаем экземпляр драйвера Chrome для автоматизации браузера
        WebDriver driver = new ChromeDriver();

        // Создаем объект для явного ожидания с таймаутом 15 секунд
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            // Открываем главную страницу Trello
            driver.get("https://trello.com");

            // Добавляем cookie с токеном сессии для автоматической аутентификации
            // Это позволяет обойти форму входа в систему
            driver.manage().addCookie(new Cookie("cloud.session.token", token));

            // Переходим на конкретную доску Trello с ID "esQuklgl" и названием "test"
            driver.get("https://trello.com/b/esQuklgl/test");

            // Ожидание загрузки колонок на доске
            // Ждем появления элементов с data-testid="list-wrapper" (контейнеры колонок)
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("li[data-testid=list-wrapper]")));

            // Получаем список всех колонок на доске
            List<WebElement> columns = driver.findElements(By.cssSelector("li[data-testid=list-wrapper]"));

            // Ожидание загрузки карточек в первой колонке (индекс 0)
            WebElement firstColumn = columns.get(0);
            wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
                    firstColumn, By.cssSelector("li[data-testid=list-card]")));

            // Получаем все карточки из первой колонки
            List<WebElement> cards = firstColumn.findElements(By.cssSelector("li[data-testid=list-card]"));

            // Находим целевую колонку для перетаскивания (третья колонка, индекс 2)
            WebElement targetColumn = columns.get(2);

            // Находим область для размещения карточек в целевой колонке
            // ol[data-testid=list-cards] - это контейнер для карточек
            WebElement dropArea = targetColumn.findElement(By.cssSelector("ol[data-testid=list-cards]"));

            // Выполняем операцию drag and drop (перетаскивание)
            new Actions(driver)
                    .clickAndHold(cards.get(0))          // Зажимаем первую карточку из первой колонки
                    .pause(Duration.ofMillis(500))       // Пауза для стабильности операции
                    .moveToElement(dropArea)             // Перемещаем к области размещения в целевой колонке
                    .pause(Duration.ofMillis(500))       // Еще одна пауза перед отпусканием
                    .release()                           // Отпускаем карточку (завершаем перетаскивание)
                    .perform();                          // Выполняем всю цепочку действий

            // Ожидание завершения операции перетаскивания
            // Thread.sleep используется для ожидания анимации и обновления UI
            Thread.sleep(2000);

        } catch (Exception e) {
            // Обработка любых исключений, которые могут возникнуть во время выполнения
            e.printStackTrace();
        } finally {
            // Блок finally гарантирует закрытие браузера даже при возникновении ошибок
            driver.quit();
        }
    }
}