package ru.merion.aqa.lesson15;

import okhttp3.*;

import java.io.IOException;

public class XClientsRequests {

    private static final MediaType JSON = MediaType.get("application/json");

    public static final String URL = "http://51.250.26.13:8083";
    public static final String COMPANY = "/company";

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        // авторизация
        XClientsWebClient service = new XClientsWebClient(URL);
        String token = service.getToken("leonardo", "leads");

        // создание организации

        String json = """
                {
                  "name": "Merion Academy",
                  "description": "Платформа доступного образования"
                }
                """;


        RequestBody reqBody = RequestBody.create(json, JSON);
        Request createNew = new Request.Builder()
                .post(reqBody)
                .header("x-client-token", token)
                .url(URL + COMPANY)
                .build();
        Response response = client.newCall(createNew).execute();
        System.out.println("Create response: " + response.body().string());

        // получение списка организаций

        Request getAllCompanies = new Request.Builder().url(URL + COMPANY).build();
        Response list = client.newCall(getAllCompanies).execute();
        System.out.println("Get all companies: " + list.body().string());
    }
}