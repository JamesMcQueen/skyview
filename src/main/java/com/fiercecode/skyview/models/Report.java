package com.fiercecode.skyview.models;

import org.joda.time.DateTime;
import com.fiercecode.skyview.utils.Ensure;

/**
 * Created by jdmq on 1/26/16.
 */
public class Report
{
    private Airport airport;
    private DateTime timestamp;

    public Report(final Airport airport)
    {
        this.airport = airport;
        timestamp = new DateTime();
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
