package com.fiercecode.skyview.utils;

import java.util.Collections;
import java.util.List;

/**
 * Created by jdmq on 1/26/16.
 */
public class Ensure
{
    public static boolean hasText(String string)
    {
        return string != null && string.length() > 0;
    }

    public static String safeString(String string)
    {
        return string != null ? string : "";
    }

    public static List safeList(List list)
    {
        return list != null ? list : Collections.emptyList();
    }
}
