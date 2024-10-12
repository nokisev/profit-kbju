package ru.nokisev.profit.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@Data
public class FatSecretService {

    private static final String BASE_URL = "https://platform.fatsecret.com/rest";


    @Value("${fatsecret.consumer_key}")
    private String consumer_key;
    @Value("${fatsecret.consumer_secret}")
    private String consumer_secret;
    @Value("${fatsecret.client_id}")
    private String client_id;
    @Value("${fatsecret.client_secret}")
    private String client_secret;
    @Value("${fatsecret.token}")
    private String token;

    private CloseableHttpClient httpClient = HttpClients.createDefault();
    private ObjectMapper objectMapper = new ObjectMapper();
    //TODO реализовать запросы к api (ключи в yml)



    public String getFoodEntries() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_URL + "/brands/v2");
        httpGet.setHeader("Authorization", "Bearer " + consumer_key);
        httpGet.setHeader("Authorization", "Bearer " + token);
        httpGet.setHeader("Content-Type", "application/json");

        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String responseBody = EntityUtils.toString(entity);

        return responseBody;
    }



}
