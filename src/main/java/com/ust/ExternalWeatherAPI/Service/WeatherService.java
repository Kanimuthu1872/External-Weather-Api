package com.ust.ExternalWeatherAPI.Service;

import com.ust.ExternalWeatherAPI.Repository.WeatherRepo;
import com.ust.ExternalWeatherAPI.model.Weather;
import com.ust.ExternalWeatherAPI.model.WeatherApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.key}")
    private String apiKey;

    @Autowired
    private WeatherRepo weatherRepository;

    public Weather getWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s?key=%s&q=%s", apiUrl, apiKey, city);
        WeatherApiResponse weatherApiResponse = restTemplate.getForObject(url, WeatherApiResponse.class);

        if (weatherApiResponse != null) {
            Weather weather = new Weather();
            weather.setLocationName(weatherApiResponse.getLocation().getName());
            weather.setTemperature(String.valueOf(weatherApiResponse.getCurrent().getTemp_c()));
            weather.setWeatherCondition(weatherApiResponse.getCurrent().getCondition().getText());

            weatherRepository.save(weather);
            return weather;
        }
        return null;
    }
}
