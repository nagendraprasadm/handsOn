package org.nm.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

public class LocaleUtil
{
    public static Locale getLocaleFromString (String localeStr)
    {
        if (!StringUtils.isEmpty(localeStr)) {
            return Locale.forLanguageTag(localeStr);
        }
        throw new RuntimeException("Input cannot be blank.");
    }
}
