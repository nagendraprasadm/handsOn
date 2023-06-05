package org.nm.lc.easy;

public class MinOperationsConvertTime2224
{
    public int convertTime(String current, String correct) {
        if(!current.equals(correct)){
            int op = 0;
            int curh = Integer.parseInt(current.split(":")[0]);
            int corh = Integer.parseInt(correct.split(":")[0]);
            int curm = Integer.parseInt(current.split(":")[1]);
            int corm = Integer.parseInt(correct.split(":")[1]);
            op += corm < curm ? corh - curh - 1 : corh - curh;
            int mind = corm < curm ? 60 - curm + corm : curm - corm;
            if(mind >= 15){
                op += mind/15;
                mind = mind%15;
            }
            if(mind >= 5){
                op += mind/5;
                mind = mind%5;
            }
            if(mind >= 1){
                op += mind;
            }
            return op;

        }
        return 0;
    }
}
