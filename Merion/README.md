# Merion AQA — автоматизация тестирования на Java

Учебный проект по автоматизации тестирования на Java по материалам курса Merion Academy и `course-aqa-java`.
В проекте есть UI-тесты на **Selenium / Selenide**, API-тесты на **OkHttp / REST Assured**, примеры JDBC/JPA, Kafka и Cucumber.

## Требования

- JDK 23+
- Maven 3.9+
- Google Chrome для UI/Cucumber (драйвер скачивается через WebDriverManager)
- PostgreSQL только для уроков 21–23
- Kafka и HTTP-сервис курса только для урока 19

## Сборка и запуск

Из каталога `Merion`:

```bash
mvn -q -DskipTests compile
mvn test
```

Запуск отдельной группы:

```bash
mvn test -Dtest='lesson_16.*'
mvn test -Dtest='lesson18.*'
mvn test -Dtest='lesson24.*'
```

`target/surefire-reports/` содержит отчёты Surefire. Allure-результаты формируются в `target/allure-results/`; при установленном Allure CLI отчёт можно открыть командой `./allure.sh`.

Полный `mvn test` включает учебные интеграционные примеры. Если внешний API, браузер, PostgreSQL или Kafka недоступны, запускайте только локальные группы либо передавайте нужную конфигурацию; интеграционные тесты не следует считать offline smoke-тестами.

## Конфигурация

Для X-Clients используется `src/test/java/ru/merion/aqa/ext/TestConfig.java`. Значения переопределяются system property или переменной окружения:

| Параметр | System property | Переменная окружения | Значение по умолчанию |
|---|---|---|---|
| Базовый URL API | `api.base.url` | `API_BASE_URL` | `http://51.250.26.13:8083` |
| Логин API | `api.login` | `API_LOGIN` | `leonardo` |
| Пароль API | `api.password` | `API_PASSWORD` | `leads` |
| Браузер | `browser` | — | `chrome` |
| Путь к расширению Chrome | `chrome.extension.path` | — | `src/main/resources/chrome_ext/...crx` |
| URL БД | `db.url` | `DB_URL` | не задан |
| Пользователь БД | `db.username` | `DB_USERNAME` | не задан |
| Пароль БД | `db.password` | `DB_PASSWORD` | не задан |

Пример запуска API с другим адресом:

```bash
mvn test -Dtest='lesson_16.*' -Dapi.base.url=http://127.0.0.1:8080
```

Конфигурационные шаблоны для Owner находятся в `src/main/resources/db.test.properties` и `db.uat.properties`. Они используют `${DB_URL}`, `${DB_USERNAME}` и `${DB_PASSWORD}`; реальные credentials не должны добавляться в Git.

## Структура

```text
src/main/java/ru/merion/aqa/
├── WebDriverFactory.java             # единая фабрика WebDriver
├── lesson2-10/                       # Selenium, waits, actions, page objects
├── lesson15/                         # OkHttp-клиент X-Clients
├── lesson17/                         # REST Assured-клиент и демонстрации
├── lesson21/                         # JDBC-примеры
├── lesson26/                         # Owner/default-properties конфигурация
├── homeworks/lesson4-21/             # домашние задания курса
└── practiceTasks/                    # локальные практические задания

src/test/java/ru/merion/aqa/
├── ext/                              # конфигурация и JUnit extensions
├── lesson_11-16/                     # локальные тесты курса
├── lesson18/lesson18_hw/             # REST Assured и employee tests
├── lesson19/                         # Kafka пример
├── lesson22/lesson23/                # JDBC/JPA тесты
├── lesson24/                         # UI/Selenide tests
├── lesson25/                         # Cucumber step definitions
├── lesson12_hw/lesson16_hw/          # домашние задания курса
└── DZ_Praktika/Practics/             # локальные задания
```

## Внешние сервисы

- API X-Clients: адрес и credentials задаются через `TestConfig`.
- UI/Cucumber: требуется Chrome и доступ к тестовым сайтам.
- DB-тесты: задайте `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`; без них не запускайте уроки 22–23.
- Kafka: урок 19 ожидает брокер и сервисы курса; без них запускайте остальные группы.

Перед коммитом проверьте `git diff --check` и убедитесь, что secrets, `target/` и локальные настройки не попали в Git.
