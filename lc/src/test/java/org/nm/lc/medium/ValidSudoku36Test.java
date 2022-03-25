package org.nm.lc.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidSudoku36Test
{
    ValidSudoku36 inst = new ValidSudoku36();

    @Test
    public void testone ()
    {
        assertTrue(inst.isValidSudoku(
            new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                           { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                           { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                           { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                           { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                           { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                           { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                           { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                           { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }));
    }
}