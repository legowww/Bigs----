package com.bigs.storage.mapper;

import com.bigs.domain.weatherforecast.Category;
import com.bigs.domain.weatherforecast.WeatherForecastContent;
import com.bigs.domain.weatherforecast.WeatherForecastIdentifier;
import com.bigs.storage.weatherforecast.WeatherForecastContentEntity;
import com.bigs.storage.weatherforecast.WeatherForecastIdentifierEntity;
import org.springframework.stereotype.Component;

@Component
public class WeatherForecastMapper {

    public WeatherForecastIdentifierEntity toEntity(
            WeatherForecastIdentifier identifier
    ) {
        return new WeatherForecastIdentifierEntity(
                identifier.baseDate(),
                identifier.baseTime(),
                identifier.nx(),
                identifier.ny()
        );
    }

    public WeatherForecastContentEntity toEntity(
            Long weatherForecastIdentifierId,
            WeatherForecastContent content
    ) {
        return new WeatherForecastContentEntity(
                content.fcstDate(),
                content.fcstTime(),
                Category.from(content.category()),
                content.fcstValue(),
                weatherForecastIdentifierId
        );
    }
}
