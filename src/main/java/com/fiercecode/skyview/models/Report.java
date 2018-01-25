package com.fiercecode.skyview.models;

import com.fiercecode.skyview.utils.Ensure;
import org.joda.time.DateTime;


/**
 * Created by jdmq on 1/26/16.
 */
public class Report
{
    private Airport airport;
    private Long timestamp;

    public Report(final Airport airport)
    {
        this.airport = airport;
        timestamp = new DateTime().getMillis();
    }

    public Airport getAirport()
    {
        return airport;
    }

    @Override
    public String toString()
    {
        return "Timestamp: " + timestamp + "\n" + airport.toString();
    }

    private boolean hasStatus()
    {
        Status status = airport.getStatus();

        return(status != null && Ensure.hasText(status.getClosureBegin()) || Ensure.hasText(status.getClosureEnd()) ||
                Ensure.hasText(status.getAvgDelay()) || Ensure.hasText(status.getMinDelay()) || Ensure.hasText(status.getMaxDelay()) ||
                Ensure.hasText(status.getType()));
    }
}
