package org.nm.lc.easy;

public class MinFlipBits2220
{
    public int minBitFlips(int start, int goal) {
        int res = start ^ goal;
        int cnt = 0;
        while(res > 0){
            cnt += res%2 != 0 ? 1 : 0;
            res = res >> 1;
        }
        return cnt;
    }
}
