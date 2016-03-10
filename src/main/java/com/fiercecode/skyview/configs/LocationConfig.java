package com.fiercecode.skyview.configs;

import com.fiercecode.skyview.models.LatLong;


/**
 * Created by jdmq on 3/10/16.
 */
public class LocationConfig extends SkyViewConfig
{
    public LocationConfig()
    {
        super("LocationConfig.properties.xml");
    }

    public LatLong getLatLong(String code)
    {
        Double[] latLong = getDoubleArray(code);

        if(latLong != null && latLong.length == 2)
        {
            return new LatLong(latLong[0], latLong[1]);
        }
        return new LatLong(0.0, 0.0);
    }
}
