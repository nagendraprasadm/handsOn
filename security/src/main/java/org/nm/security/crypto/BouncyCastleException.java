package org.nm.security.crypto;

public class BouncyCastleException extends RuntimeException
{
    public BouncyCastleException (String message)
    {
        super(message);
    }

    public BouncyCastleException (String message, Throwable cause)
    {
        super(message, cause);
    }
}
