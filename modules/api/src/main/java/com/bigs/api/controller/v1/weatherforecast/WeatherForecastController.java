package com.bigs.api.controller.v1.weatherforecast;

import com.bigs.api.global.response.ApiResponse;
import com.bigs.domain.weatherforecast.WeatherForecast;
import com.bigs.domain.weatherforecast.WeatherForecastIdentifier;
import com.bigs.domain.weatherforecast.WeatherForecastService;
import com.bigs.api.controller.v1.weatherforecast.response.WeatherForecastFindResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.net.URI;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class WeatherForecastController {

    private final WeatherForecastService weatherForecastService;

    @GetMapping("/v1/weather-forecasts")
    public ResponseEntity<ApiResponse<WeatherForecastFindResponse>> findWeatherForecast(
            @RequestParam Long nx,
            @RequestParam Long ny,
            @RequestParam String baseDate,
            @RequestParam String baseTime
    ) {
        WeatherForecast weatherForecast = weatherForecastService.find(WeatherForecastIdentifier.of(nx, ny, baseDate, baseTime));
        return ResponseEntity.ok(ApiResponse.ok(WeatherForecastFindResponse.of(weatherForecast)));
    }

    @PostMapping("/v1/weather-forecasts")
    public ResponseEntity<ApiResponse<Void>> saveWeatherForecast(
            @RequestParam Long nx,
            @RequestParam Long ny,
            @RequestParam String baseDate,
            @RequestParam String baseTime
    ) {
        weatherForecastService.save(WeatherForecastIdentifier.of(nx, ny, baseDate, baseTime));
        return ResponseEntity.created(getUri(nx, ny, baseDate, baseTime)).body(ApiResponse.created(null));
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


//    @GetMapping("/a")
//    public ResponseEntity<WeatherForecastFindResponse> test() {
////        WeatherForecastFindResponse response = weatherForecastService.find(new WeatherForecastTarget("62", "130", "20240504", "0500"));
//
//        return ResponseEntity.ok(response);
//    }
}
