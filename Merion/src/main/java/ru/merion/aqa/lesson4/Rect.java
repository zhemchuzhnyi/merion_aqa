package ru.merion.aqa.lesson4;

// Импорт основных классов Selenium для работы с веб-элементами
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// Импорт фабрики для создания экземпляров веб-драйвера
import ru.merion.aqa.WebDriverFactory;

/**
 * Класс демонстрирует получение геометрических параметров веб-элементов:
 * размеры, координаты и границы элемента на странице
 */
public class Rect {

    public static void main(String[] args) {

        // Создание экземпляра веб-драйвера Chrome
        WebDriver driver = WebDriverFactory.create("chrome");

        // Переход на главную страницу Habr
        driver.get("https://habr.com/ru/feed/");

        // Поиск и сохранение ссылки на заголовок первой статьи
        // Это позволит избежать повторного поиска элемента для каждой операции
        WebElement el = driver.findElement(By.cssSelector(".tm-article-title__link"));

        // === ПОЛУЧЕНИЕ РАЗМЕРОВ И КООРДИНАТ ЭЛЕМЕНТА ===

        // 1. getRect().getDimension() - получение объекта Dimension с шириной и высотой
        // Возвращает объект с методами getWidth() и getHeight()
        // Эквивалентно getSize(), но через другой API
        el.getRect().getDimension();

        // 2. getRect().getWidth() - получение ширины элемента в пикселях
        // Возвращает int значение ширины элемента
        el.getRect().getWidth();

        // 3. getRect().getHeight() - получение высоты элемента в пикселях
        // Возвращает int значение высоты элемента
        el.getRect().getHeight();

        // 4. getLocation().getX() - получение X-координаты левого верхнего угла
        // Возвращает int значение позиции по горизонтали относительно страницы
        el.getLocation().getX();

        // 5. getSize().getWidth() - альтернативный способ получения ширины
        // Возвращает int значение ширины, аналогично getRect().getWidth()
        el.getSize().getWidth();

        // ПРИМЕЧАНИЕ: В коде отсутствуют:
        // - getLocation().getY() - Y-координата (вертикальная позиция)
        // - getSize().getHeight() - высота через getSize()
        // - getRect().getX(), getRect().getY() - координаты через getRect()

        // Закрытие только текущего окна браузера
        // close() - закрывает текущую вкладку, quit() - закрывает весь браузер
        driver.close();
    }
}