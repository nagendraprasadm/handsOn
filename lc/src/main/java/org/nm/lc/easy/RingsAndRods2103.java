package org.nm.lc.easy;

public class RingsAndRods2103
{
    public int countPoints(String rings) {
        boolean[] trk = new boolean[30];
        //b=0, g = 1, r =2
        for(int i = 0; i < rings.length(); i = i + 2){
            char col = rings.charAt(i);
            int rod = Character.getNumericValue(rings.charAt(i+1));
            int pos = (col == 'B'? 0 : (col == 'G' ? 1 : 2));
            rod = rod == 0 ? 0 : (rod * 3);
            trk[rod + pos] = true;
        }

        int sz = 0;
        boolean prev = true;
        int cnt = 0;
        for(boolean cur : trk){
            prev = prev & cur;
            sz++;
            if(sz == 3){
                cnt += prev ? 1 : 0;
                prev = true;
                sz = 0;
            }
        }
        return cnt;
    }
}
