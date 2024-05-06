package com.bigs.domain.weatherforecast;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Component
public class WeatherForecastWriter {

    private final WeatherForecastApiClient weatherForecastApiClient;
    private final WeatherForecastRepository weatherForecastRepository;

    @Transactional
    public void save(
            WeatherForecastIdentifier identifier
    ) {
        List<WeatherForecastContent> contents = weatherForecastApiClient.execute(identifier.nx(), identifier.ny(), identifier.baseDate(), identifier.baseTime());
        weatherForecastRepository.save(identifier, contents);
    }
}
