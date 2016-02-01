package com.fiercecode.skyview.retrievers;

/**
 * Created by jdmq on 1/26/16.
 */
public class AirportRequest
{
    //"http://services.faa.gov/airport/status/SEA?format=json"

    public static String buildRequest(String airportCode)
    {
        return String.format("http://services.faa.gov/airport/status/%s?format=json", airportCode);
    }
}
