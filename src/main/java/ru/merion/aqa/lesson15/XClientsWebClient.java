package ru.merion.aqa.lesson15;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import ru.merion.aqa.lesson15.model.AuthRequest;
import ru.merion.aqa.lesson15.model.AuthResponse;

import java.io.IOException;

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
        AuthResponse authResponse = mapper.readValue(jsonResp, AuthResponse.class);
        return authResponse;
    }
}
