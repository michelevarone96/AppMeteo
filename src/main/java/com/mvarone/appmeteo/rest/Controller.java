package com.mvarone.appmeteo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mvarone.appmeteo.core.OpenWeatherService;

@RestController
public class Controller {

    private final OpenWeatherService openWeatherService;

    @Autowired
    public Controller(OpenWeatherService openWeatherService) {
        this.openWeatherService = openWeatherService;
    }

    @GetMapping("/mvarone/openweather/v1/city")
    public String getWeather(@RequestParam String name) {
        return openWeatherService.getCurrentWeather(name);
    }
}
