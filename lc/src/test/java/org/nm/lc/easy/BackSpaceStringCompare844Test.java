package org.nm.lc.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class BackSpaceStringCompare844Test
{

    BackSpaceStringCompare844 isnt = new BackSpaceStringCompare844();

    @Test
    public void testone(){
        assertTrue(isnt.backspaceCompare("y#fo##f",
                                         "y#f#o##f"));
    }
}