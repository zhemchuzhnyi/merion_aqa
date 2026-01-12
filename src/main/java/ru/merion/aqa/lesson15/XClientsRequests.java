package ru.merion.aqa.lesson15;

import okhttp3.*;
import ru.merion.aqa.lesson15.model.AuthRequest;

import java.io.IOException;

public class XClientsRequests {

    private static final MediaType JSON = MediaType.get("application/json");

    public static final String URL = "http://51.250.26.13:8083";
    public static final String COMPANY = "/company";
    public static final String LOGIN = "/auth/login";

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        // авторизация
        AuthRequest authRequest = new AuthRequest("leonardo","leads");
        RequestBody authBody = RequestBody.create(creds, JSON);

        Request authReq = new Request.Builder().post(authBody).url(URL + LOGIN).build();
        Response authResp = client.newCall(authReq).execute();
        System.out.println("Auth response: " + authResp.body().string());


        // создание организации

        String json = """
                {
                  "name": "Merion Academy",
                  "description": "Платформа доступного образования"
                }
                """;

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlIjoiYWRtaW4iLCJpYXQiOjE3NjgwNzM5NjcsImV4cCI6MTc2ODA3NDg2N30.OJ49pPFJdsbWLeRdqosr0PoiUlQgmAJVIqeJos5eAjs";
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