package com.bigs.storage.weatherforecast;


import com.bigs.domain.weatherforecast.Category;
import com.bigs.storage.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class WeatherForecastContentEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fcstDate;

    @Column(nullable = false)
    private String fcstTime;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    private String fcstValue;

    @Column(nullable = false)
    private Long weatherForecastIdentifierId;

    public WeatherForecastContentEntity(String fcstDate, String fcstTime, Category category, String fcstValue, Long weatherForecastIdentifierId) {
        this.fcstDate = fcstDate;
        this.fcstTime = fcstTime;
        this.category = category;
        this.fcstValue = fcstValue;
        this.weatherForecastIdentifierId = weatherForecastIdentifierId;
    }
}
