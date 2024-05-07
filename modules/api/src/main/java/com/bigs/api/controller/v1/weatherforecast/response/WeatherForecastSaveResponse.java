package com.bigs.api.controller.v1.weatherforecast.response;

import com.bigs.domain.weatherforecast.WeatherForecast;

public record WeatherForecastSaveResponse(
        Long nx,
        Long ny,
        String baseDate,
        String baseTime
) {

    public static WeatherForecastSaveResponse of(
            Long nx,
            Long ny,
            String baseDate,
            String baseTime
    ) {
        return new WeatherForecastSaveResponse(nx, ny, baseDate, baseTime);
    }
}
