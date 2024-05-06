package com.bigs.domain.weatherforecast;

import java.util.List;

public interface WeatherForecastRepository {

    void save(WeatherForecastIdentifier identifier, List<WeatherForecastContent> contents);

    List<WeatherForecastContent> findByIdentifier(WeatherForecastIdentifier identifier);
}
