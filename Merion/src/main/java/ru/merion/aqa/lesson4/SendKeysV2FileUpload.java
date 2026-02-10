package ru.merion.aqa.lesson4;

// Импорт основных классов Selenium для работы с веб-элементами
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// Импорт фабрики для создания экземпляров веб-драйвера
import ru.merion.aqa.WebDriverFactory;

/**
 * Класс демонстрирует загрузку файлов через веб-интерфейс с помощью Selenium
 * Показывает, как использовать sendKeys() для input[type="file"] элементов
 */
public class SendKeysV2FileUpload {

    public static void main(String[] args) {

        // Создание экземпляра веб-драйвера Chrome
        WebDriver driver = WebDriverFactory.create("chrome");

        // Переход на тестовую страницу загрузки файлов на "The Internet"
        // Страница содержит форму с полем выбора файла и кнопкой отправки
        driver.get("https://the-internet.herokuapp.com/upload");

        // === ЗАГРУЗКА ФАЙЛА ===

        // Поиск поля загрузки файла по ID и передача пути к файлу
        // Элемент <input type="file" id="file-upload"> принимает абсолютный путь к файлу
        // sendKeys() для input[type="file"] НЕ открывает диалог выбора файла,
        // а напрямую устанавливает путь к файлу в поле
        // ВАЖНО: путь должен быть абсолютным и файл должен существовать
        driver.findElement(By.cssSelector("#file-upload")).sendKeys("/Users/a0000/IdeaProjects/merion_aqa/btn.png");

        // === ОТПРАВКА ФОРМЫ ===

        // Нажатие кнопки "Upload" для отправки выбранного файла на сервер
        // После успешной загрузки произойдет переход на страницу с подтверждением
        // и информацией о загруженном файле
        driver.findElement(By.cssSelector("#file-submit")).click();

        // Корректное закрытие браузера и освобождение ресурсов
        driver.quit();
    }
}