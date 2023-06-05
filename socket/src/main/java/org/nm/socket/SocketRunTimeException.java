package org.nm.socket;

public class SocketRunTimeException extends RuntimeException
{
    public SocketRunTimeException (String message)
    {
        super(message);
    }

    public SocketRunTimeException (String message, Throwable t)
    {
        super(message, t);
    }
}
