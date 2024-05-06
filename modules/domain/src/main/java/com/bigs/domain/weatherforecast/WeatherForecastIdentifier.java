package com.bigs.domain.weatherforecast;

public record WeatherForecastIdentifier(
        String nx,
        String ny,
        String baseDate,
        String baseTime
) {

    public static WeatherForecastIdentifier of(
        Long nx,
        Long ny,
        String baseDate,
        String baseTime
    ) {
        return new WeatherForecastIdentifier(String.valueOf(nx), String.valueOf(ny), baseDate, baseTime);
    }
}
