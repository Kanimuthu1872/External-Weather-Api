package com.ust.ExternalWeatherAPI.Controller;

import com.ust.ExternalWeatherAPI.Service.WeatherService;
import com.ust.ExternalWeatherAPI.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController { // Corrected class name

    @Autowired
    private WeatherService service;

    @GetMapping("/weather")
    public ResponseEntity<Weather> getWeather(@RequestParam String city) {
        Weather weatherData = service.getWeather(city);
        if (weatherData != null) {
            return new ResponseEntity<>(weatherData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
