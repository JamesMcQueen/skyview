package com.fiercecode.skyview.retrievers;

import com.fiercecode.skyview.configs.AirportConfig;
import com.fiercecode.skyview.models.Airport;
import com.fiercecode.skyview.models.Report;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Created by jdmq on 3/9/16.
 */
public class FlightRetriever
{
    private static AirportConfig config = new AirportConfig();
    private static Map<String, Report> airportReportMap;

    public static Map<String, Report> getAirportReports()
    {
        initReportMap();
        return airportReportMap;
    }

    public static Report getAirportReport(String code)
    {
        initReportMap();
        return airportReportMap.get(code);
    }

    private static void initReportMap()
    {
        if(airportReportMap == null || airportReportMap.size() == 0)
        {
            airportReportMap = new ConcurrentHashMap<>();
            config.getAirportCodes()
                    .parallelStream()
                    .map(code -> airportReportMap.put(code, new Report(getAirport(code))))
                    .collect(Collectors.toList());
        }
    }

    private static Airport getAirport(String code)
    {
        Airport airport = new Gson().fromJson(callURL(AirportRequest.buildRequest(code), config.getTimeout()), Airport.class);

        if(airport == null)
        {
            airport = new Airport();
        }

        return airport;
    }

    private static String callURL(String myURL, Integer timeout)
    {
        StringBuilder sb = new StringBuilder();

        try
        {
            InputStreamReader in = null;
            URL url = new URL(myURL);
            URLConnection urlConn = url.openConnection();
            if (urlConn != null)
            {
                urlConn.setReadTimeout(timeout);
            }
            if (urlConn != null && urlConn.getInputStream() != null)
            {
                in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null)
                {
                    int cp;

                    while ((cp = bufferedReader.read()) != -1)
                    {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                }
            }
            in.close();
        }
        catch (Exception e)
        {
            throw new RuntimeException("Exception while calling URL:"+ myURL, e);
        }

        return sb.toString();
    }
}
