package com.bigs.storage.weatherforecast;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WeatherForecastIdentifierEntityJpaRepository extends JpaRepository<WeatherForecastIdentifierEntity, Long> {

}
