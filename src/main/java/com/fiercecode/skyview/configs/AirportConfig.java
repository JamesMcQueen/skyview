package com.fiercecode.skyview.configs;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jdmq on 1/26/16.
 */
public class AirportConfig extends SkyViewConfig
{
    public AirportConfig()
    {
        super("AirportConfig.properties.xml");
    }

    public Integer getDelay()
    {
        return Integer.valueOf(getValue("repeatDelay"));
    }

    public Integer getTimeout()
    {
        return Integer.valueOf(getValue("timeout"));
    }

    public List<String> getAirportCodes()
    {
        String[] codes = getValue("airportCodes").split(",");

        return Arrays.asList(codes);
    }

    public List<String> getNorthwestAirportCodes()
    {
        return Arrays.asList(getValue("nwAirportCodes").split(","));
    }
}
