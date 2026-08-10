# Merion AQA — автоматизация тестирования на Java

Учебный проект по автоматизации тестирования (курс Merion Academy).
UI-тесты на **Selenium / Selenide** + **JUnit 5**, API-тесты на **OkHttp / REST Assured**.

## Требования

- JDK 23+
- Maven 3.9+
- Google Chrome (драйвер скачивается автоматически через WebDriverManager)

## Запуск тестов

```bash
mvn test
```

Одной конкретной папки:

```bash
mvn test -Dtest='lesson_16.*'
```

Отчёты: `target/surefire-reports/` (JUnit), кастомный HTML — `target/reports/`.

## Конфигурация тестового окружения

По умолчанию всё берётся из `TestConfig` (`src/test/java/ru/merion/aqa/ext/TestConfig.java`).
Значения переопределяются системным свойством или переменной окружения:

| Параметр                | System property    | Переменная окружения | По умолчанию              |
|-------------------------|--------------------|----------------------|---------------------------|
| Базовый URL X-Clients   | `api.base.url`     | `API_BASE_URL`       | `http://51.250.26.13:8083` |
| Логин API               | `api.login`        | `API_LOGIN`          | `leonardo`                |
| Пароль API              | `api.password`     | `API_PASSWORD`       | `leads`                   |
| Путь к расширению Chrome| `chrome.extension.path` | —               | `src/main/resources/chrome_ext/...crx` |

Пример:

```bash
mvn test -Dapi.base.url=http://127.0.0.1:8080
```

> onrender-инстанс X-Clients больше не отвечает (404) — используйте живой URL из таблицы.

## Структура

```
src/main/java/ru/merion/aqa/
├── WebDriverFactory.java        # единая фабрика драйверов (WebDriverManager)
├── lesson2-10/                  # примеры по урокам (Selenium, waits, actions, page object)
├── lesson7/page/                # Page Objects сайта Лабиринт
├── lesson8/                     # Selenide
├── lesson15/                    # OkHttp-клиент для X-Clients API
└── practiceTasks/               # домашние задания

src/test/java/ru/merion/aqa/
├── ext/                         # TestConfig, ClientProvider, TokenProvider (JUnit extensions)
├── lesson_11/12/13/             # тесты + JUnit extensions (репортер, инъекция драйвера)
├── lesson_16/                   # contract / business / homework тесты X-Clients API
└── DZ_Praktika/                 # домашние задания (Selenium + page object)
```
