package org.nm.common;

public class StringUtil
{

    public static void main (String[] args)
    {
        System.out.println(
            "application.properties".matches("application-(.)+.properties"));
    }
}
