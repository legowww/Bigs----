package com.bigs.storage.weatherforecast;

import com.bigs.domain.weatherforecast.WeatherForecastIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WeatherForecastIdentifierEntityJpaRepository extends JpaRepository<WeatherForecastIdentifierEntity, Long> {

    @Query(
            value = """
                    SELECT wi.id
                    FROM WeatherForecastIdentifierEntity wi
                    WHERE wi.baseDate = :baseDate 
                    AND wi.baseTime = :baseTime 
                    AND wi.nx = :nx
                    AND wi.ny = :ny
                    """
    )
    Optional<Long> findByIdentifier(String baseDate, String baseTime, String nx, String ny);
}
