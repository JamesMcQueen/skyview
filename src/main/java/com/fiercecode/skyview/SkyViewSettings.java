package com.fiercecode.skyview;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by jdmq on 1/30/16.
 */
@ConfigurationProperties
public class SkyViewSettings
{
    private String appName;
    private String version;
    private String other;

    public SkyViewSettings()
    {
        // no arg constructor
    }

    public String getAppName()
    {
        return appName;
    }

    public void setAppName(final String appName)
    {
        this.appName = appName;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(final String version)
    {
        this.version = version;
    }

    public String getOther()
    {
        return other;
    }

    public void setOther(final String other)
    {
        this.other = other;
    }
}
