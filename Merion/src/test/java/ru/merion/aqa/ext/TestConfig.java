package ru.merion.aqa.ext;

/**
 * Центральный источник конфигурации тестового окружения.
 * Значения можно переопределить системным свойством (-Dapi.base.url=...)
 * или переменной окружения (API_BASE_URL).
 */
public final class TestConfig {

    // Единственный живой бэкенд X-Clients. onrender-инстанс больше не отвечает (404).
    public static final String BASE_URL = property("api.base.url", "http://51.250.26.13:8083");
    public static final String LOGIN = property("api.login", "leonardo");
    public static final String PASSWORD = property("api.password", "leads");

    private TestConfig() {
    }

    private static String property(String key, String defaultValue) {
        String value = System.getProperty(key);
        if (value == null || value.isBlank()) {
            value = System.getenv(key.toUpperCase().replace('.', '_'));
        }
        return value != null && !value.isBlank() ? value : defaultValue;
    }
}