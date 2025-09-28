package ru.merion.aqa.lesson4;

// Импорт основных классов Selenium для работы с веб-элементами
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// Импорт фабрики для создания экземпляров веб-драйвера
import ru.merion.aqa.WebDriverFactory;

/**
 * Класс демонстрирует различные способы получения свойств и атрибутов
 * веб-элементов в Selenium WebDriver:
 * - getAttribute() - HTML-атрибуты и DOM-свойства
 * - getDomProperty() - DOM-свойства элемента
 * - getDomAttribute() - HTML-атрибуты элемента
 * - getCssValue() - CSS-свойства элемента
 */
public class Properties {

    public static void main(String[] args) {

        // Создание экземпляра веб-драйвера Chrome
        WebDriver driver = WebDriverFactory.create("chrome");

        // Переход на главную страницу Habr для работы со статьями
        driver.get("https://habr.com/ru/feed/");

        // === РАЗЛИЧНЫЕ СПОСОБЫ ПОЛУЧЕНИЯ АТРИБУТА "translate" ===

        // 1. getAttribute() - универсальный метод (устаревший подход)
        // Возвращает значение HTML-атрибута или DOM-свойства
        // Если атрибут не найден, пытается найти соответствующее DOM-свойство
        String target1 = driver.findElement(By.cssSelector(".tm-article-title__link")).getAttribute("translate");

        // 2. getDomProperty() - получение DOM-свойства элемента (современный подход)
        // Возвращает значение свойства объекта в DOM дереве
        // Более точный и быстрый способ для получения актуальных значений
        String target2 = driver.findElement(By.cssSelector(".tm-article-title__link")).getDomProperty("translate");

        // 3. getDomAttribute() - получение HTML-атрибута элемента (современный подход)
        // Возвращает значение атрибута из HTML разметки
        // Показывает изначальное значение, а не текущее состояние
        String target3 = driver.findElement(By.cssSelector(".tm-article-title__link")).getDomAttribute("translate");

        // 4. getCssValue() - получение CSS-свойства элемента
        // Возвращает вычисленное CSS-значение свойства
        // Для атрибута "translate" скорее всего вернет null или пустую строку
        String target4 = driver.findElement(By.cssSelector(".tm-article-title__link")).getCssValue("translate");

        // === ПОЛУЧЕНИЕ ТЕКСТОВОГО СОДЕРЖИМОГО ЭЛЕМЕНТА ===

        // Получение внутреннего текста элемента через getAttribute("innerText")
        // innerText - DOM-свойство, содержащее видимый текст элемента
        // Аналогично методу getText(), но через другой механизм
        String innerText = driver.findElement(By.cssSelector(".tm-article-title__link")).getAttribute("innerText");

        // Вывод заголовка первой статьи на Habr в консоль
        // Это будет название статьи из ссылки с классом "tm-article-title__link"
        System.out.println(innerText);

        // Корректное закрытие браузера и освобождение ресурсов
        driver.quit();
    }
}