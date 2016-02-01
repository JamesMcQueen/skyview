package com.fiercecode.skyview.models;

/**
 * Created by jdmq on 1/26/16.
 */
public class LatLong
{
    private double latitude = 0.0;
    private double longitude = 0.0;

    public LatLong(Double latitude, Double longitude)
    {
        if(latitude != null)
        {
            this.latitude = latitude.doubleValue();
        }
        if(longitude != null)
        {
            this.longitude = longitude.doubleValue();
        }
    }

    public LatLong getLatLong()
    {
        return this;
    }

    public double getLatitude()
    {
        return this.latitude;
    }

    public double getLongitude()
    {
        return this.longitude;
    }
}
