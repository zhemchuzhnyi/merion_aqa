package ru.merion.aqa.lesson15;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import ru.merion.aqa.lesson15.model.AuthRequest;
import ru.merion.aqa.lesson15.model.AuthResponse;
import ru.merion.aqa.lesson15.model.CreateNewCompanyRequest;

import java.io.IOException;

import static ru.merion.aqa.lesson15.XClientsRequests.COMPANY;

public class XClientsWebClient {

    private static final MediaType JSON = MediaType.get("application/json");

    private static final String LOGIN = "/auth/login";

    private final String URL;

    private final OkHttpClient client;

    private final ObjectMapper mapper;

    public XClientsWebClient(String URL) {
        mapper = new ObjectMapper();
        client = new OkHttpClient();
        this.URL = URL;
    }

    public String getToken(String login, String pass) throws IOException {
        return auth(login, pass).userToken();
    }

    public AuthResponse auth(String login, String pass) throws IOException {
        AuthRequest authRequest = new AuthRequest(login, pass);
        String jsonRequest = mapper.writeValueAsString(authRequest);
        RequestBody requestBody = RequestBody.create(jsonRequest, JSON);
        Request authReq = new Request.Builder().post(requestBody).url(URL + LOGIN).build();
        Response authResp = client.newCall(authReq).execute();
        String jsonResp = authResp.body().string();
        return mapper.readValue(jsonResp, AuthResponse.class);
    }

    public int create(String name, String description, String token) throws IOException {
        CreateNewCompanyRequest createNewCompanyRequest = new CreateNewCompanyRequest(name, description);
        String jsonRequest = mapper.writeValueAsString(createNewCompanyRequest);
        RequestBody requestBody = RequestBody.create(jsonRequest, JSON);
        Request request = new Request.Builder()
                .post(requestBody)
                .header("x-client-token", token)
                .url(URL + COMPANY)
                .build();

        Response response = client.newCall(request).execute();
        String jsonResponce = response.body().string();
        int id = mapper.readValue(jsonResponce, Integer.class);

        return id;
    }
}