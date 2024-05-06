package com.bigs.storage.weatherforecast;


import com.bigs.domain.weatherforecast.WeatherForecastContent;
import com.bigs.domain.weatherforecast.WeatherForecastIdentifier;
import com.bigs.storage.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class WeatherForecastIdentifierEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String baseDate;

    @Column(nullable = false)
    private String baseTime;

    @Column(nullable = false)
    private String nx;

    @Column(nullable = false)
    private String ny;

    public WeatherForecastIdentifierEntity(String baseDate, String baseTime, String nx, String ny) {
        this.baseDate = baseDate;
        this.baseTime = baseTime;
        this.nx = nx;
        this.ny = ny;
    }
}
