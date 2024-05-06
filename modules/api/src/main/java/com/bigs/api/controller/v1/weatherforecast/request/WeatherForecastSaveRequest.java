package com.bigs.api.controller.v1.weatherforecast.request;

import org.springframework.web.bind.annotation.PathVariable;

public record WeatherForecastSaveRequest(
        Long nx,
        Long ny,
        String baseDate
) {
}
