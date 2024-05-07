package com.bigs.api.controller.v1.weatherforecast;

import com.bigs.api.controller.v1.weatherforecast.request.WeatherForecastSaveRequest;
import com.bigs.api.controller.v1.weatherforecast.response.WeatherForecastSaveResponse;
import com.bigs.api.global.response.ApiResponse;
import com.bigs.domain.weatherforecast.WeatherForecast;
import com.bigs.domain.weatherforecast.WeatherForecastIdentifier;
import com.bigs.domain.weatherforecast.WeatherForecastService;
import com.bigs.api.controller.v1.weatherforecast.response.WeatherForecastFindResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class WeatherForecastController {

    private final WeatherForecastService weatherForecastService;

    @GetMapping("/api/v1/weather-forecasts")
    public ResponseEntity<ApiResponse<WeatherForecastFindResponse>> findWeatherForecast(
            @RequestParam Long nx,
            @RequestParam Long ny,
            @RequestParam String baseDate,
            @RequestParam String baseTime
    ) {
        WeatherForecast weatherForecast = weatherForecastService.find(WeatherForecastIdentifier.of(nx, ny, baseDate, baseTime));

        if (weatherForecast.weatherForecastContents().isEmpty()) {
            return ResponseEntity.noContent()
                    .build();
        }

        return ResponseEntity.ok(ApiResponse.ok(WeatherForecastFindResponse.of(weatherForecast)));
    }

    @PostMapping("/api/v1/weather-forecasts")
    public ResponseEntity<ApiResponse<WeatherForecastSaveResponse>> saveWeatherForecast(
        @Validated @RequestBody WeatherForecastSaveRequest request
    ) {
        weatherForecastService.save(WeatherForecastIdentifier.of(request.nx(), request.ny(), request.baseDate(), request.baseTime()));
        return ResponseEntity.created(getUri(request.nx(), request.ny(), request.baseDate(), request.baseTime()))
                .body(ApiResponse.created(WeatherForecastSaveResponse.of(request.nx(), request.ny(), request.baseDate(), request.baseTime())));
    }

    private URI getUri(Long nx, Long ny, String baseDate, String baseTime) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .queryParam("nx", nx)
                .queryParam("ny", ny)
                .queryParam("baseDate", baseDate)
                .queryParam("baseTime", baseTime)
                .build()
                .toUri();
    }
}
