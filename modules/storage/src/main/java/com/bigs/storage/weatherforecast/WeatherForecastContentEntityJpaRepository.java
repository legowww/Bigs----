package com.bigs.storage.weatherforecast;

import com.bigs.domain.weatherforecast.WeatherForecastIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WeatherForecastContentEntityJpaRepository extends JpaRepository<WeatherForecastContentEntity, Long> {

    List<WeatherForecastContentEntity> findByWeatherForecastIdentifierId(Long identifierId);
}
