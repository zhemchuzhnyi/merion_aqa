package ru.merion.aqa.lesson15;

import okhttp3.*;

import java.io.IOException;

public class XClientsRequests {

    private static final MediaType JSON = MediaType.get("application/json");

    public static final String URL = "http://51.250.26.13:8083/docs/";
    public static final String COMPANY = "/company";
    public static final String LOGIN = "/auth/login";

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

//        Request getAllCompanies = new Request.Builder().url(URL + COMPANY).build();
//        Response response = client.newCall(getAllCompanies).execute();
//        System.out.println(response.body().string());

        String creds = """
                {
                  "username": "leonardo",
                  "password": "leads"
                }
                """;

        RequestBody authBody = RequestBody.create(creds, JSON);
        Request authReq = new Request.Builder().post(authBody).url(URL + LOGIN).build();
        Response authResp = client.newCall(authReq).execute();
        System.out.println(authResp.body().string());

        String json = """
                {
                  "name": "Merion Academy",
                  "description": "Платформа доступного образования"
                }
                """;


        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlIjoiYWRtaW4iLCJpYXQiOjE3NjgwNzMwNTksImV4cCI6MTc2ODA3Mzk1OX0.nNzwYwKMOayrOkg_Lfe_uUPhrE3vDXAB3YJVwYxwwOg";
        RequestBody reqBody = RequestBody.create(json, JSON);
        Request createNew = new Request.Builder()
                .post(reqBody)
                .header("x-client-token", token)
                .url(URL + COMPANY)
                .build();
        Response response = client.newCall(createNew).execute();
        System.out.println(response.body().string());

    }
}
