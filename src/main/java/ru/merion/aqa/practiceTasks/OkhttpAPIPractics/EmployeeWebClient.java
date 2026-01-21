package ru.merion.aqa.practiceTasks.OkhttpAPIPractics;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import ru.merion.aqa.lesson15.MyCustomLogger;

public class EmployeeWebClient {
    private static final MediaType JSON = MediaType.get("application/json");

    private static final String LOGIN = "/auth/login";

    private static final String Employee = "/employee";

    private final String URL;

    private final OkHttpClient client;

    private final ObjectMapper mapper;

    public EmployeeWebClient(String URL) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new MyCustomLogger());
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        mapper = new ObjectMapper();
        client = new OkHttpClient.Builder().addNetworkInterceptor(interceptor).build();

        this.URL = URL;
    }
}
