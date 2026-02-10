/*
Прогресс бар - ПРАВИЛЬНОЕ решение задачи

Использование явного ожидания (Explicit Wait) - это Best Practice в Selenium!
Этот подход является стандартом индустрии для работы с динамическим контентом.
*/
package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;

/**
 * Четвертый и ПРАВИЛЬНЫЙ вариант решения задачи с прогресс-баром.
 * Демонстрирует использование Explicit Wait (явного ожидания) - Best Practice подход.
 *
 * Преимущества этого решения:
 * ✅ Чистый и читаемый код (всего 3 строки вместо циклов)
 * ✅ Встроенная защита от таймаута
 * ✅ Автоматическая обработка StaleElementException
 * ✅ Оптимальное использование ресурсов
 * ✅ Стандарт индустрии
 * ✅ Подходит для CI/CD
 */
public class ProgressbarV4Norm {

    public static void main(String[] args) throws InterruptedException {
        // Инициализация WebDriver для браузера Chrome
        WebDriver driver = WebDriverFactory.create("chrome");

        // Открываем страницу с прогресс-баром
        driver.get("http://uitestingplayground.com/progressbar");

        // Запускаем прогресс-бар кликом по кнопке "Start"
        driver.findElement(By.cssSelector("#startButton")).click();

        // ========== ЯВНОЕ ОЖИДАНИЕ (EXPLICIT WAIT) - BEST PRACTICE ==========

        // Создаем объект WebDriverWait с двумя параметрами:
        // 1. Duration.ofSeconds(60) - МАКСИМАЛЬНОЕ время ожидания (таймаут)
        //    Если условие не выполнится за 60 секунд → TimeoutException
        //    Это "страховка" от бесконечного ожидания
        //
        // 2. Duration.ofMillis(100) - ИНТЕРВАЛ ОПРОСА (polling interval)
        //    Как часто WebDriver будет проверять условие
        //    100 мс = проверка каждые 0.1 секунды
        //    Это оптимальное значение: не слишком часто (не нагружает CPU),
        //    и не слишком редко (не пропустит целевое значение)
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(60),      // Таймаут
                Duration.ofMillis(100));     // Polling interval

        // ========== ОЖИДАНИЕ КОНКРЕТНОГО ТЕКСТА ==========

        // wait.until() - ждет, пока условие не станет истинным
        // ExpectedConditions.textToBe() - проверяет ТОЧНОЕ совпадение текста элемента
        //
        // Параметры:
        // - By.cssSelector("#progressBar") - локатор элемента прогресс-бара
        // - "75%" - ожидаемый текст (ТОЧНОЕ совпадение, включая символ %)
        //
        // КАК ЭТО РАБОТАЕТ:
        // 1. WebDriverWait каждые 100 мс проверяет текст элемента #progressBar
        // 2. Сравнивает полученный текст с "75%"
        // 3. Если текст совпадает → метод возвращает WebElement, выполнение продолжается
        // 4. Если не совпадает → ждет следующие 100 мс и повторяет проверку
        // 5. Если за 60 секунд текст не стал "75%" → выбрасывает TimeoutException
        //
        // АВТОМАТИЧЕСКАЯ ОБРАБОТКА ОШИБОК:
        // - StaleElementException - автоматически повторяет поиск элемента
        // - NoSuchElementException - повторяет попытку найти элемент
        //
        // ВАЖНО: textToBe() проверяет getText(), а не getAttribute("aria-valuenow")!
        // getText() возвращает видимый текст: "75%"
        // getAttribute("aria-valuenow") возвращает: "75" (без символа %)
        wait.until(ExpectedConditions.textToBe(By.cssSelector("#progressBar"), "75%"));

        // ✅ Если мы дошли до этой строки, значит прогресс достиг 75%!
        // Больше не нужно проверять условие - WebDriverWait уже это сделал

        // Останавливаем прогресс-бар кликом по кнопке "Stop"
        driver.findElement(By.cssSelector("#stopButton")).click();

        // Выводим сообщение об успешном завершении
        System.out.println("Finished");

        // Закрываем браузер и освобождаем ресурсы
        driver.quit();
    }
}