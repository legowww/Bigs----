package com.bigs.domain.weatherforecast;

import java.util.List;

public interface WeatherForecastApiClient {

    List<WeatherForecastContent> execute(
            String nx,
            String ny,
            String baseDate,
            String baseTime
    );
}
