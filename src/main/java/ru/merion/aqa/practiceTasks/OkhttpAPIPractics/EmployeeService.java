package ru.merion.aqa.practiceTasks.OkhttpAPIPractics;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import java.io.IOException;

public class EmployeeService {
    private static final MediaType JSON = MediaType.get("application/json");
    private static final String BASE_URL = "http://51.250.26.13:8083";
    private static final String LOGIN_PATH = "/auth/login";
    private static final String EMPLOYEE_PATH = "/employee";

    private final OkHttpClient client;
    private final ObjectMapper mapper;
    private final String token;

    /**
     * Конструктор принимает логин и пароль для авторизации
     */
    public EmployeeService(String login, String password) throws IOException {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        this.client = new OkHttpClient.Builder()
                .addNetworkInterceptor(interceptor)
                .build();
        this.mapper = new ObjectMapper();

        // Получаем токен при создании сервиса
        this.token = authenticate(login, password);
    }

    /**
     * Метод для получения токена авторизации
     */
    private String authenticate(String login, String password) throws IOException {
        String json = String.format("{\"username\":\"%s\",\"password\":\"%s\"}", login, password);
        RequestBody body = RequestBody.create(json, JSON);

        Request request = new Request.Builder()
                .url(BASE_URL + LOGIN_PATH)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Ошибка авторизации: " + response.code());
        }
        String responseBody = response.body().string();
        return mapper.readTree(responseBody).get("userToken").asText();
    }

    /**
     * Получить список сотрудников компании
     */
    public String getEmployeeList(int companyId) throws IOException {
        String url = BASE_URL + EMPLOYEE_PATH + "?company=" + companyId;

        Request request = new Request.Builder()
                .url(url)
                .header("x-client-token", token)
                .get()
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Ошибка получения списка: " + response.code());
        }
        return response.body().string();
    }

    /**
     * Получить сотрудника по ID
     */
    public String getEmployeeById(int id) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + EMPLOYEE_PATH + "/" + id)
                .header("x-client-token", token)
                .get()
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Ошибка получения сотрудника: " + response.code());
        }
        return response.body().string();
    }

    /**
     * Создать нового сотрудника
     */
    public int createEmployee(int companyId, String firstName, String lastName,
                              String phone, boolean isActive) throws IOException {
        String json = String.format(
                "{\"companyId\":%d,\"firstName\":\"%s\",\"lastName\":\"%s\",\"phone\":\"%s\",\"isActive\":%b}",
                companyId, firstName, lastName, phone, isActive
        );

        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(BASE_URL + EMPLOYEE_PATH)
                .header("x-client-token", token)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Ошибка создания сотрудника: " + response.code());
        }
        String responseBody = response.body().string();
        return mapper.readTree(responseBody).get("id").asInt();
    }

    /**
     * Изменить данные сотрудника
     */
    public String updateEmployee(int id, String lastName, String email,
                                 String phone, boolean isActive) throws IOException {
        String json = String.format(
                "{\"lastName\":\"%s\",\"email\":\"%s\",\"phone\":\"%s\",\"isActive\":%b}",
                lastName, email, phone, isActive
        );

        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(BASE_URL + EMPLOYEE_PATH + "/" + id)
                .header("x-client-token", token)
                .patch(body)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Ошибка обновления сотрудника: " + response.code());
        }
        return response.body().string();
    }

    /**
     * Получить токен (для отладки)
     */
    public String getToken() {
        return token;
    }
}