package com.ust.ExternalWeatherAPI.Repository;

import com.ust.ExternalWeatherAPI.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepo extends JpaRepository<Weather,Long> {
}
