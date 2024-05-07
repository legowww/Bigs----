package com.bigs.weatherapiclient.openapi.client;


import com.bigs.domain.weatherforecast.WeatherForecastContent;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VilageFcstApiMapper {

    public List<WeatherForecastContent> mapFrom(String result) {

        try {
            JSONObject json = new JSONObject(result);
            JSONObject response = (JSONObject) json.get("response");
            JSONObject body = (JSONObject) response.get("body");
            JSONObject items = (JSONObject) body.get("items");
            JSONArray item = (JSONArray) items.get("item");

            List<WeatherForecastContent> weatherForecastContents = new ArrayList<>();
            for (int i = 0; i < item.length(); ++i) {
                JSONObject it = (JSONObject) item.get(i);
                String category = it.get("category").toString();
                String fcstDate = it.get("fcstDate").toString();
                String fcstTime = it.get("fcstTime").toString();
                String fcstValue = it.get("fcstValue").toString();

                weatherForecastContents.add(new WeatherForecastContent(fcstDate, fcstTime, category, fcstValue));
            }

            return weatherForecastContents;

        } catch (Exception exception) {
            throw new RuntimeException("단기예보API 호출에 실패하였습니다. 다시 호출해주세요");
        }
    }
}
