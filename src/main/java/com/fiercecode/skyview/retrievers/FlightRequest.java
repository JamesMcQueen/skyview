package com.fiercecode.skyview.retrievers;

/**
 * Created by jdmq on 3/9/16.
 */
public class FlightRequest
{
    public static String buildRequest(String airportCode)
    {
        return String.format("https://api.flightstats.com/flex/flightstatus/v2/json/airport/tracks/airport/dep GET/", airportCode);
    }
}
