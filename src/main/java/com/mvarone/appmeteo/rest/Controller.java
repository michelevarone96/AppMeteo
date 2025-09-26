package com.mvarone.appmeteo.rest;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mvarone.appmeteo.core.OpenWeatherService;
import com.mvarone.appmeteo.util.elastic.log.Log;
import com.mvarone.appmeteo.util.elastic.log.LogRepository;

@RestController
public class Controller {

    private final OpenWeatherService openWeatherService;

    @Autowired
    private LogRepository logRepo;

    @Autowired
    public Controller(OpenWeatherService openWeatherService) {
        this.openWeatherService = openWeatherService;
    }

    @GetMapping("/mvarone/openweather/v1/city")
    public String getWeather(@RequestParam String name) {
        Log log = new Log();
        log.setId("Mike_test1");
        log.setLevel("DEBUG");
        log.setMessage("Il servizio di /mvarone/openweather/v1/city è stato richiamato");
        log.setPayload_applicativo("Request: " + name + ", Respose: " + openWeatherService.getCurrentWeather(name));
        log.setTimestamp(LocalDateTime.now());
        logRepo.save(log);
        return openWeatherService.getCurrentWeather(name);
    }
}
