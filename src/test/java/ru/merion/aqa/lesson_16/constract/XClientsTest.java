package ru.merion.aqa.lesson_16.constract;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

public class XClientsTest {

    public static final String URL = "http://51.250.26.13:8083/docs/#/company";

    @Test
    public void shouldReturnArrayOnGetCompanyList() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(URL).build();
        Response response = client.newCall(request).execute();


    }
}
