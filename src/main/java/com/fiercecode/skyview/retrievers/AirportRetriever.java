package com.fiercecode.skyview.retrievers;

import com.fiercecode.skyview.models.Report;
import com.google.gson.Gson;

import com.fiercecode.skyview.configs.AirportConfig;
import com.fiercecode.skyview.models.Airport;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jdmq on 1/26/16.
 */
public class AirportRetriever
{
    private static AirportConfig config = new AirportConfig();

    public static List<Report> getAirportReports()
    {
        return config.getAirportCodes().parallelStream()
                .map(code -> new Report(getAirport(code)))
                .collect(Collectors.toList());
    }

    public static List<Airport> getAirports()
    {
       return config.getAirportCodes()
               .parallelStream()
               .map(code -> getAirport(code))
               .collect(Collectors.toList());
    }

    public static Airport getAirport(String code)
    {
        Airport airport = new Gson().fromJson(callURL(AirportRequest.buildRequest(code), config.getTimeout()), Airport.class);

        if(airport == null)
        {
            airport = new Airport();
        }

        return airport;
    }

    public static String callURL(String myURL, Integer timeout)
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
