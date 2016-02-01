package com.fiercecode.skyview.services;

import com.fiercecode.skyview.models.Airport;
import com.fiercecode.skyview.models.Report;
import com.fiercecode.skyview.models.Weather;
import com.fiercecode.skyview.retrievers.AirportRetriever;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jdmq on 1/26/16.
 */
public class AirportService
{
    public static List<Airport> getAirports()
    {
        return AirportRetriever.getAirports();
    }

    public static Airport getAirport(String id)
    {
        return AirportRetriever.getAirport(id);
    }

    public static List<Report> getReports()
    {
        return AirportRetriever.getAirportReports();
    }

    public static Map getWeatherReports()
    {
        Map<String, Weather> weatherMap = new HashMap();

        AirportRetriever.getAirports().stream()
                .filter(a -> a.getWeather() != null)
                .forEach(a -> weatherMap.put(a.getIATA(), a.getWeather()));

        return weatherMap;
    }
}
