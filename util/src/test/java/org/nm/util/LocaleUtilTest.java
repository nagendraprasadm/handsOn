package org.nm.util;

import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class LocaleUtilTest extends TestCase
{
    private static final Logger logger = LoggerFactory.getLogger(LocaleUtilTest.class);

    public void testStringToLocale ()
    {
        Locale enUsLocale = LocaleUtil.getLocaleFromString("en-US");
        assertNotNull(enUsLocale);
        assertEquals("en", enUsLocale.getLanguage());
        assertEquals("US", enUsLocale.getCountry());
        logger.info("Locale toString of en-US is, {} and to language tag is {}",
                    enUsLocale.toString(), enUsLocale.toLanguageTag());
    }

    public void testStringToLocaleInvalid ()
    {
        Locale enUsLocale = LocaleUtil.getLocaleFromString("en_US");
        assertNotNull(enUsLocale);
        assertEquals("en", enUsLocale.getLanguage());
        assertEquals("US", enUsLocale.getCountry());
        logger.info("Locale toString of en-US is, {} and to language tag is {}",
                    enUsLocale.toString(), enUsLocale.toLanguageTag());
    }

    public void testStringToLocalezh ()
    {
        Locale enUsLocale = LocaleUtil.getLocaleFromString("ZH-CN");
        assertNotNull(enUsLocale);
        assertEquals("en", enUsLocale.getLanguage());
        assertEquals("US", enUsLocale.getCountry());
        logger.info("Locale toString of en-US is, {} and to language tag is {}",
                    enUsLocale.toString(), enUsLocale.toLanguageTag());
    }

}