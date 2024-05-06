package com.bigs.domain.weatherforecast;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WeatherForecastService {

    private final WeatherForecastReader weatherForecastReader;
    private final WeatherForecastWriter weatherForecastWriter;

    public WeatherForecast find(
            WeatherForecastIdentifier identifier
    ) {
        List<WeatherForecastContent> contents = weatherForecastReader.read(identifier);
        return WeatherForecast.of(identifier, contents);
    }

    public void save(
            WeatherForecastIdentifier identifier
    ) {
        weatherForecastWriter.save(identifier);
    }
}
