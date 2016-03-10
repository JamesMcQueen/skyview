package com.fiercecode.skyview.configs;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by jdmq on 1/26/16.
 */
public class SkyViewConfig
{
    private Properties properties = new Properties();


    public SkyViewConfig()
    {
        // no arg constructor
    }

    public SkyViewConfig(String configFileName)
    {
        try
        {
            properties.loadFromXML(getClass().getClassLoader().getResourceAsStream(configFileName));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public String getValue(String key)
    {
        return properties.getProperty(key);
    }

    public Double[] getDoubleArray(String key)
    {
        String values = (String) properties.get(key);

        if(values != null && values.contains(","))
        {
            String[] valueArr = values.split(",");

            if(valueArr.length > 0)
            {
                return parseDoubles(valueArr);
            }
        }
        return null;
    }

    private Double[] parseDoubles(final String[] valueArr)
    {
        Double latLong[] = new Double[valueArr.length];
        for(int i = 0; i < valueArr.length; i++)
        {
            try
            {
                latLong[i] = Double.valueOf(valueArr[i]);
            }
            catch(NumberFormatException nfe)
            {
                latLong[i] = 0.0;
            }
        }
        return latLong;
    }
}