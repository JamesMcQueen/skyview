package com.fiercecode.skyview.models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;


/**
 * Created by jdmq on 1/26/16.
 */
public class Weather
{
    public class Meta
    {
        @SerializedName("credit")
        private String source;
    }

    @SerializedName("weather")
    private String condition;
    private Meta meta;
    private String temp;
    private String wind;
    private Integer visibility;

    public Weather(){}

    public Weather(String condition, String source, String temp, String wind, final Integer visibility)
    {
        meta = new Meta();
        meta.source = source;
        this.condition = condition;
        this.temp = temp;
        this.wind = wind;
        this.visibility = visibility;
    }
    public String getCondition()
    {
        return condition;
    }

    public String getSource()
    {
        return this.meta.source;
    }

    public String getTemp()
    {
        return temp;
    }

    public String getWind()
    {
        return wind;
    }

    public Integer getVisibility()
    {
        return visibility;
    }

    public String toJson()
    {
        return new Gson().toJson(this);
    }

    @Override
    public String toString()
    {
        return String.format("Weather: {conditon = %s | source = %s | temp = %s | wind = %s | visibility = %d}", condition, meta.source, temp, wind, visibility);
    }
}
