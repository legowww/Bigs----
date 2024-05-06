package com.bigs.api.controller.v1.weatherforecast.response;

import com.bigs.domain.weatherforecast.WeatherForecast;

public record WeatherForecastFindResponse(
        WeatherForecast weatherForecast
) {

    public static WeatherForecastFindResponse of(
            WeatherForecast weatherForecast
    ) {
        return new WeatherForecastFindResponse(weatherForecast);
    }
}
