package ru.merion.aqa.lesson15;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import ru.merion.aqa.lesson15.model.AuthRequest;
import ru.merion.aqa.lesson15.model.AuthResponse;

public class XClientsWebClient {

    private final OkHttpClient client;
    private final ObjectMapper mapper;

    public XClientsWebClient() {
        mapper = new ObjectMapper();
        client = new OkHttpClient();
    }

    public AuthResponse auth(String login, String pass) {
        AuthRequest authRequest = new AuthRequest(login, pass);
        String jsonRequest = mapper.writeValueAsString(authRequest);
        RequestBody requestBody = RequestBody.create(jsonRequest, JSON);
        Request authReq = new Request.Builder().post(requestBody).url(URL + LOGIN).build();
        Response authResp = client.newCall(authReq).execute();
        String jsonResp = authResp.body().string();
        AuthResponse authResponse = mapper.readValue(jsonResp, AuthResponse.class);
    }
}
