package com.fiercecode.skyview.models;

import com.google.gson.Gson;

/**
 * Created by jdmq on 1/26/16.
 */
public class Airport
{
    private String name = "NO NAME";
    private String IATA;
    private String state;
    private String city;

    private Boolean delay;
    private Weather weather;
    private Status status;
    private LatLong latLong;

    public Airport(){}

    public Airport(final Status status, final String name, final String IATA, final String state, final String city,
                   final Boolean delay, final Weather weather, final LatLong latLong)
    {
        this.status = status;
        this.name = name;
        this.IATA = IATA;
        this.state = state;
        this.city = city;
        this.delay = delay;
        this.weather = weather;
        this.latLong = latLong;
    }

    public String getName()
    {

        return name;
    }

    public String getIATA()
    {
        return IATA;
    }

    public String getState()
    {
        return state;
    }

    public String getCity()
    {
        return city;
    }

    public Boolean getDelay()
    {
        return delay;
    }

    public Weather getWeather()
    {
        return weather;
    }

    public Status getStatus()
    {
        return status;
    }

    @Override
    public String toString()
    {
        String TAB = "\t";
        String NEXTLINE = "\n";

        StringBuilder sb = new StringBuilder(String.format("Airport: {name = %s | IATA = %s | state = %s | city = %s | delay = %b", name,IATA,state,city,delay));

        sb.append(NEXTLINE).append(TAB).append(weather.toString());
        sb.append(NEXTLINE).append(TAB).append(status.toString()).append("}").append(NEXTLINE);

        return sb.toString();
    }

    public String toString(boolean hasStatus)
    {
        String TAB = "\t";
        String NEXTLINE = "\n";

        StringBuilder sb = new StringBuilder(String.format("Airport: {name = %s | IATA = %s | state = %s | city = %s | delay = %b", name,IATA,state,city,delay));

        sb.append(NEXTLINE).append(TAB).append(weather.toString());
        if(hasStatus)
        {
            sb.append(NEXTLINE).append(TAB).append(status.toString()).append("}").append(NEXTLINE);
        }

        return sb.toString();
    }
}
