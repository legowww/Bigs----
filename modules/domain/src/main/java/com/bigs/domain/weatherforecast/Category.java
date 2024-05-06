package com.bigs.domain.weatherforecast;

public enum Category {
    POP, PTY, PCP, REH, SNO, SKY, TMP,
    TMN, TMX, UUU, VVV, WAV, VEC, WSD;

    public static Category from(String category) {
        return Category.valueOf(category);
    }
}
