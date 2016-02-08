package com.fiercecode.skyview.services;

import com.fiercecode.skyview.models.Airport;
import com.fiercecode.skyview.models.Report;
import com.fiercecode.skyview.retrievers.AirportRetriever;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jdmq on 1/26/16.
 */
public class AirportService
{
    public static List<Report> getReports()
    {
        return AirportRetriever.getAirportReports().values()
                .parallelStream()
                .filter(report -> report != null)
                .collect(Collectors.toList());
    }

    public static Report getReport(String id)
    {
        return AirportRetriever.getAirportReport(id);
    }

    public static List<Airport> getAirports()
    {
        return getReports()
                .parallelStream()
                .filter(report -> report.getAirport() != null)
                .map(Report::getAirport)
                .collect(Collectors.toList());
    }

    public static Airport getAirport(String id)
    {
        return getReport(id).getAirport();
    }

    public static List<Airport> getAirportsByWeather(String condition)
    {
        return getAirports()
                .parallelStream()
                .filter(a -> a.getWeather() != null)
                .filter(a -> a.getWeather().getCondition() != null)
                .filter(a -> a.getWeather().getCondition().toLowerCase().matches(condition.toLowerCase()))
                .collect(Collectors.toList());
    }
}
