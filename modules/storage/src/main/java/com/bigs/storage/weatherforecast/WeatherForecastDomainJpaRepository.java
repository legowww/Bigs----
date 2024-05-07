package com.bigs.storage.weatherforecast;

import com.bigs.domain.weatherforecast.WeatherForecastContent;
import com.bigs.domain.weatherforecast.WeatherForecastRepository;
import com.bigs.domain.weatherforecast.WeatherForecastIdentifier;
import com.bigs.storage.support.WeatherForecastDomainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class WeatherForecastDomainJpaRepository implements WeatherForecastRepository {

    private final WeatherForecastDomainMapper mapper;
    private final WeatherForecastIdentifierEntityJpaRepository identifierEntityJpaRepository;
    private final WeatherForecastContentEntityJpaRepository contentEntityJpaRepository;

    @Override
    public void save(
            WeatherForecastIdentifier identifier,
            List<WeatherForecastContent> contents
    ) {
        WeatherForecastIdentifierEntity identifierEntity = identifierEntityJpaRepository.save(mapper.toEntity(identifier));

        List<WeatherForecastContentEntity> contentEntities = contents.stream()
                .map(content -> mapper.toEntity(identifierEntity.getId(), content))
                .toList();

        contentEntityJpaRepository.saveAll(contentEntities);
    }

    @Override
    public List<WeatherForecastContent> findByIdentifier(
            WeatherForecastIdentifier identifier
    ) {
        Optional<Long> optId = identifierEntityJpaRepository.findByIdentifier(identifier.baseDate(), identifier.baseTime(), identifier.nx(), identifier.ny());

        if (optId.isEmpty()) {
            return Collections.emptyList();
        }

        return contentEntityJpaRepository.findByWeatherForecastIdentifierId(optId.get())
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
