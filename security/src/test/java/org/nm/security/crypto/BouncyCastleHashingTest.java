package org.nm.security.crypto;

import junit.framework.TestCase;

public class BouncyCastleHashingTest extends TestCase
{

    public void testOne() {
        BouncyCastleHashing hashing = new BouncyCastleHashing();
        String hash = hashing.hash("Sample Text");
        String hash2 = hashing.hash("Sample Text.");
        assertFalse(hash.equals(hash2));
    }

}