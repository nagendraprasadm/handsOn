package org.nm.util;

import org.apache.commons.lang3.StringUtils;

public class ErrorUtil
{
    public static final int MAX_CHARACTERS = 250;

    public static final int TOTAL_MAX_CHARACTERS = 1000;

    public static String getCompleteCausedByErrors (Throwable exception)
    {
        StringBuilder resultBuilder = new StringBuilder();
        if (exception != null) {
            Throwable causedBy = exception;
            while (causedBy != null) {
                if (resultBuilder.length() > 0) {
                    resultBuilder.append(" --> ");
                }
                resultBuilder.append(
                    getNormalizedMessage(causedBy.getMessage(), MAX_CHARACTERS));
                causedBy = causedBy.getCause();
            }
        }
        if (resultBuilder.length() > TOTAL_MAX_CHARACTERS) {
            return resultBuilder.substring(0, TOTAL_MAX_CHARACTERS);
        }
        return resultBuilder.toString();
    }

    private static String getNormalizedMessage (String message, int maxLength)
    {
        if (!StringUtils.isEmpty(message)) {
            if (message.length() > maxLength) {
                message = message.substring(0, maxLength);
            }
            return message;
        }
        return "Empty";
    }
}
