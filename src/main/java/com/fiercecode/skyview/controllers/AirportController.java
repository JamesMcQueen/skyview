package com.fiercecode.skyview.controllers;

import com.fiercecode.skyview.services.AirportService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by jdmq on 1/26/16.
 */
@RestController
public class AirportController
{
    private static final Gson GSON = new GsonBuilder().disableHtmlEscaping().create();

    @RequestMapping(value = "/airports", method = RequestMethod.GET)
    public static String getAirports()
    {
        return GSON.toJson(AirportService.getAirports()).toString();
    }

    @RequestMapping(value = "/airports/{id}", method = RequestMethod.GET)
    public static String getAirports(@PathVariable("id") String id)
    {
        return GSON.toJson(AirportService.getAirport(id));
    }

    @RequestMapping(value = "/airports/reports", method = RequestMethod.GET)
    public static String getAirportReports()
    {
        return GSON.toJson(AirportService.getReports());
    }

    @RequestMapping(value = "/weather", method = RequestMethod.GET)
    public static String getAirportsWithWeather()
    {
        return GSON.toJson(AirportService.getWeatherReports());
    }
}
