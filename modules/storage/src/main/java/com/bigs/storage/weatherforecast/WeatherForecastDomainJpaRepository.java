package com.bigs.storage.weatherforecast;

import com.bigs.domain.weatherforecast.WeatherForecastContent;
import com.bigs.domain.weatherforecast.WeatherForecastRepository;
import com.bigs.domain.weatherforecast.WeatherForecastIdentifier;
import com.bigs.storage.mapper.WeatherForecastMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class WeatherForecastDomainJpaRepository implements WeatherForecastRepository {

    private final WeatherForecastMapper mapper;
    private final WeatherForecastIdentifierEntityJpaRepository identifierEntityJpaRepository;
    private final WeatherForecastContentEntityJpaRepository contentEntityJpaRepository;

    @Override
    public void save(
            WeatherForecastIdentifier identifier,
            List<WeatherForecastContent> contents
    ) {
        WeatherForecastIdentifierEntity identifierEntity = identifierEntityJpaRepository.save(mapper.toEntity(identifier));
        Long identifierEntityId = identifierEntity.getId();

        List<WeatherForecastContentEntity> contentEntities = contents.stream()
                .map(contentEntity -> mapper.toEntity(identifierEntityId, contentEntity))
                .toList();

        contentEntityJpaRepository.saveAll(contentEntities);
    }

    @Override
    public List<WeatherForecastContent> findByIdentifier(
            WeatherForecastIdentifier identifier
    ) {
        return null;
    }
}
