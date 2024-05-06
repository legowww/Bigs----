package com.bigs.weatherapiclient.openapi.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "open-api")
public class OpenApiProperties {

    private final VilageFcst vilageFcst;

    public record VilageFcst(String url, String serviceKey) {
    }
}
