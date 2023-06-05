package org.nm.lc.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO/RETRY
 */
public class MinMovesCovertStr2027
{
    private static final Logger logger = LoggerFactory.getLogger(MinMovesCovertStr2027.class);

    public int minimumMoves(String s) {
        int ix = s.indexOf("XXX");
        int op = 0;
        while(ix > -1){
            s = s.substring(0,ix) + "OOO" +s.substring(ix+3);
            op++;
            ix = s.indexOf("XXX");
        }
        logger.info("After removing 3 - {}", op);
        ix = s.indexOf("XX");
        while(ix > -1){
            s = s.substring(0,ix) + "OO" + s.substring(ix+3);
            op++;
            ix = s.indexOf("XX");
        }
        logger.info("After removing 3 and 2 - {}", op);
        ix = s.indexOf("XOX");
        while(ix > -1){
            s = s.substring(0,ix) + "OOO" + s.substring(ix+3);
            op++;
            ix = s.indexOf("XOX");
        }
        logger.info("After removing 3, 2, XOX - {}", op);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'X'){
                op++;
            }
        }
        return op;
    }
}
