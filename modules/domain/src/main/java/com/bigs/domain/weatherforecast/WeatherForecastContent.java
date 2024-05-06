package com.bigs.domain.weatherforecast;

public record WeatherForecastContent(
        String fcstDate,
        String fcstTime,
        String category,
        String fcstValue
) {
}
