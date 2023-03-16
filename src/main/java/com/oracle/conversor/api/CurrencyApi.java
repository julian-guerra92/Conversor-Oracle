package com.oracle.conversor.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CurrencyApi {

    private static final String API_BASE_URL = "https://api.apilayer.com/currency_data";
    private String apiKey;
    private Map<String, String> currenciesList;

    public CurrencyApi() throws IOException {
        Properties properties = new Properties();
        InputStream entry = new FileInputStream(".properties");
        properties.load(entry);
        apiKey = properties.getProperty("currency_key");
        currenciesList = new HashMap<>();
    }

    public void getListCurrency() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(API_BASE_URL + "/list"))
                .GET()
                .header("apiKey", apiKey)
                .build();
        HttpResponse<String> httpResponse = httpClient.send(
                httpRequest,
                HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)
        );
        JSONObject response = new JSONObject(httpResponse.body());
        JSONObject currencies = response.getJSONObject("currencies");
        for (String key : currencies.keySet()) {
            String value = (String) currencies.get(key);
            currenciesList.put(key, value);
        }
    }

    public float getExchangeRate(String currenci, String source) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(API_BASE_URL + "/live?source=" + source + "&currencies=" + currenci))
                .GET()
                .header("apiKey", apiKey)
                .build();
        HttpResponse<String> httpResponse = httpClient.send(
                httpRequest,
                HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)
        );
        JSONObject response = new JSONObject(httpResponse.body());
        JSONObject exchageRate = response.getJSONObject("quotes");
        return exchageRate.getFloat(source+currenci);
    }

}