package com.bigs.api.controller.v1.weatherforecast.request;

import jakarta.validation.constraints.NotNull;

public record WeatherForecastSaveRequest(
        @NotNull(message = "nx은 필수 값 입니다.")
        Long nx,
        @NotNull(message = "ny은 필수 값 입니다.")
        Long ny,
        @NotNull(message = "baseDate는 필수 값 입니다.")
        String baseDate,
        @NotNull(message = "baseTime은 필수 값 입니다.")
        String baseTime
) {
}
