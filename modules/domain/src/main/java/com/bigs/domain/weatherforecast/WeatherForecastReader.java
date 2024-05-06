package com.bigs.domain.weatherforecast;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Component
public class WeatherForecastReader {

    private final WeatherForecastRepository weatherForecastRepository;

    @Transactional(readOnly = true)
    public List<WeatherForecastContent> read(
            WeatherForecastIdentifier identifier
    ) {
        List<WeatherForecastContent> contents = weatherForecastRepository.findByIdentifier(identifier);
        return contents;
    }
}
