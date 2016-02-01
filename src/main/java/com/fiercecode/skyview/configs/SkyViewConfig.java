package com.fiercecode.skyview.configs;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by jdmq on 1/26/16.
 */
public class SkyViewConfig
{
    private Properties properties = new Properties();

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

    public SkyViewConfig()
    {

    }

    public String getValue(String key)
    {
        return properties.getProperty(key);
    }
}
