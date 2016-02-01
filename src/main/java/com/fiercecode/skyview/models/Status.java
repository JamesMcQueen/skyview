package com.fiercecode.skyview.models;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Created by jdmq on 1/26/16.
 */
public class Status
{
    private String reason;
    private String closureBegin;
    private String endTime;
    private String minDelay;
    private String avgDelay;
    private String maxDelay;
    private String closureEnd;
    private String trend;
    private String type;

    public Status(){}

    public Status(final String reason, final String closureBegin, final String endTime,
                  final String minDelay, final String avgDelay, final String maxDelay,
                  final String closureEnd, final String trend, final String type)
    {
        this.reason = reason;
        this.closureBegin = closureBegin;
        this.endTime = endTime;
        this.minDelay = minDelay;
        this.avgDelay = avgDelay;
        this.maxDelay = maxDelay;
        this.closureEnd = closureEnd;
        this.trend = trend;
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    public String getReason()
    {
        return reason;
    }

    public String getClosureBegin()
    {
        return closureBegin;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public String getMinDelay()
    {
        return minDelay;
    }

    public String getAvgDelay()
    {
        return avgDelay;
    }

    public String getMaxDelay()
    {
        return maxDelay;
    }

    public String getClosureEnd()
    {
        return closureEnd;
    }

    public String getTrend()
    {
        return trend;
    }

    @Override
    public String toString()
    {
        return String.format("Status: {reason = %s | closureBegin = %s | endTime = %s | minDelay = %s | avgDelay = %s | maxDelay = %s | closureEnd = %s | trend = %s | type = %s}",
                reason,closureBegin,endTime,minDelay,avgDelay,maxDelay,closureEnd,trend,type);
    }
}
