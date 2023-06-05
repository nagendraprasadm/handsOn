package org.nm.security.crypto;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.Security;

public class BouncyCastleHashing implements Hashing
{
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    @Override
    public String hash (String originalString) throws BouncyCastleException
    {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
            return new String(Hex.encode(hash));
        }
        catch (Exception e) {
            throw new BouncyCastleException(
                "Error while trying to encode string - " + originalString);
        }
    }
}
