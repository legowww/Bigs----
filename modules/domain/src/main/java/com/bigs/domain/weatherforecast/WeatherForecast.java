package com.bigs.domain.weatherforecast;

import java.util.List;

public record WeatherForecast(
        WeatherForecastIdentifier weatherForecastIdentifier,
        List<WeatherForecastContent> weatherForecastContents
) {

    public static WeatherForecast of(
            WeatherForecastIdentifier weatherForecastIdentifier,
            List<WeatherForecastContent> weatherForecastContents
    ) {
        return new WeatherForecast(weatherForecastIdentifier, weatherForecastContents);
    }
}
