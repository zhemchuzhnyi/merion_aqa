package ru.merion.aqa.lesson4;

// Импорт основных классов Selenium для работы с веб-элементами
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
// Импорт фабрики для создания экземпляров веб-драйвера
import ru.merion.aqa.WebDriverFactory;

/**
 * Класс демонстрирует различные способы ввода текста и использования клавиш
 * в Selenium WebDriver:
 * - Ввод обычного текста
 * - Комбинации клавиш (chord)
 * - Специальные клавиши (Keys)
 * - Выделение и удаление текста
 */
public class SendKeys {

    public static void main(String[] args) {

        // Создание экземпляра веб-драйвера Chrome
        WebDriver driver = WebDriverFactory.create("chrome");

        // Переход на тестовую страницу UI Testing Playground для работы с текстовым вводом
        // Страница содержит поле ввода и кнопку, которая изменяет свой текст на введенное значение
        driver.get("http://uitestingplayground.com/textinput");

        // === ПОЭТАПНЫЙ ВВОД ТЕКСТА ===

        // 1. Ввод первой части текста "Welcome!" в поле с id="newButtonName"
        // sendKeys() добавляет текст к уже существующему содержимому поля
        driver.findElement(By.cssSelector("#newButtonName")).sendKeys("Welcome!");

        // 2. Добавление второй части текста " To site!" к уже введенному
        // Результат в поле: "Welcome! To site!"
        driver.findElement(By.cssSelector("#newButtonName")).sendKeys(" To site!");

        // === РАБОТА С ВЫДЕЛЕНИЕМ ТЕКСТА ===

        // 3. Выделение части текста с помощью комбинации клавиш
        // Keys.chord() - создает комбинацию из нескольких клавиш, нажимаемых одновременно
        // LEFT_SHIFT + ARROW_UP - выделяет текст от текущей позиции курсора вверх/влево
        // ВАЖНО: ARROW_UP в текстовом поле работает как выделение к началу строки
        driver.findElement(By.cssSelector("#newButtonName")).sendKeys(Keys.chord(Keys.LEFT_SHIFT, Keys.ARROW_UP));

        // 4. Удаление выделенного текста
        // BACK_SPACE - клавиша Backspace для удаления
        // Если текст выделен - удаляет весь выделенный текст
        // Если ничего не выделено - удаляет один символ слева от курсора
        driver.findElement(By.cssSelector("#newButtonName")).sendKeys(Keys.BACK_SPACE);

        // === ПРИМЕНЕНИЕ ИЗМЕНЕНИЙ ===

        // 5. Нажатие кнопки для применения введенного текста
        // Кнопка с id="updatingButton" изменит свой текст на значение из поля ввода
        // Это демонстрирует динамическое обновление элементов на странице
        driver.findElement(By.cssSelector("#updatingButton")).click();

        // Корректное закрытие браузера и освобождение ресурсов
        driver.quit();
    }
}