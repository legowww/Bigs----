package com.bigs.weatherapiclient.openapi.client;


import com.bigs.domain.weatherforecast.WeatherForecastApiClient;
import com.bigs.domain.weatherforecast.WeatherForecastContent;
import com.bigs.weatherapiclient.openapi.config.OpenApiProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@Component
public class VilageFcstApiClient implements WeatherForecastApiClient {

    private final RestTemplate restTemplate;
    private final OpenApiProperties properties;
    private final VilageFcstApiMapper mapper;

    @Override
    public List<WeatherForecastContent> execute(
            String nx,
            String ny,
            String baseDate,
            String baseTime
    ) {
        URI url = getUri(nx, ny, baseDate, baseTime);
        String result = restTemplate.getForObject(url, String.class);

        return mapper.mapFrom(result);
    }

    private URI getUri(
            String nx,
            String ny,
            String baseDate,
            String baseTime
    ) {
        URI url = UriComponentsBuilder
                .fromHttpUrl(properties.getVilageFcst().url())
                .queryParam("serviceKey", properties.getVilageFcst().serviceKey())
                .queryParam("pageNo", "1")
                .queryParam("numOfRows", "1000")
                .queryParam("dataType", "JSON")
                .queryParam("nx", nx)
                .queryParam("ny", ny)
                .queryParam("base_date", baseDate)
                .queryParam("base_time", baseTime)
                .build()
                .toUri();

        return url;
    }
}
