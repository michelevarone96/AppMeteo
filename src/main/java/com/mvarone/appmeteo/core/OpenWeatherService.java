package com.mvarone.appmeteo.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mvarone.appmeteo.config.OpenWeatherConfig;

@Service
public class OpenWeatherService {

    private final OpenWeatherConfig config;

    @Autowired
    public OpenWeatherService(OpenWeatherConfig config) {
        this.config = config;
    }
    public String getCurrentWeather(String city) {
        try {
            if (city == null || city.isEmpty()) {
                return "{\"error\":\"Nome della città non valido\"}";
            }
            String urlString = config.getBaseurl() + "?q=" + city + "&appid=" + config.getKey() + "&units=metric&lang=it";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\":\"Impossibile recuperare i dati del meteo\"}";
        }
    }
}
