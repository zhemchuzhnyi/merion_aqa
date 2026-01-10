package ru.merion.aqa.lesson15;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class XClientsRequests {

    public static final String URL = "http://51.250.26.13:8083/docs/";
    public static final String COMPANY = "/company";
    public static final String LOGIN = "/auth/login";

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

//        Request getAllCompanies = new Request.Builder().url(URL + COMPANY).build();
//        Response response = client.newCall(getAllCompanies).execute();
//        System.out.println(response.body().string());

        String json = """
                {
                  "name": "string",
                  "description": "string"
                }
                """;

        RequestBody reqBody = RequestBody.create()
        Request createNew = new Request.Builder().post().url(URL + COMPANY).build();

    }
}
