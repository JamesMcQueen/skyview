package com.fiercecode.skyview.models;

import org.joda.time.DateTime;

/**
 * Created by jdmq on 1/26/16.
 */
public class Airport
{
    private static final String NO_VALUE = "NO_NAME";
    private String name = NO_VALUE;
    private String IATA;
    private String state;
    private String city;

    private Boolean delay;
    private Weather weather;
    private Status status;
    private LatLong latLong;
    private DateTime created;

    public Airport(){}

    public Airport(final LatLong latLong)
    {
        this.latLong = latLong;
    }

    public Airport(final Status status, final String name, final String IATA, final String state, final String city,
                   final Boolean delay, final Weather weather)
    {
        this.created = new DateTime();
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
    public String getCreated()
    {
        return created.toDateTime().toString();
    }

    public boolean isValid()
    {
        return this.getIATA() != null && this.name.matches(NO_VALUE);
    }

    public LatLong getLatLong()
    {
        return latLong;
    }

    public void setLatLong(final LatLong latLong)
    {
        this.latLong = latLong;
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
