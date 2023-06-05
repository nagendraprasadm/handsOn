package org.nm.lc.easy;

public class ReverseBits190
{
    public int reverseBits(int n) {
        int answer = 0;
        int res = 0;
        for (int i=0;i<32;i++) {
            answer = answer << 1; // Move all bits recorded until now to left and make room in the last bit.
            res = res << 1;
            answer = answer | (n & 1);  // Extract the last bit from n (n&1) and add it to the last bit of the answer (answer | last bit)
            //res = res + (n&1);
            if((n&1) != 0){
                res += 1;
            }
            System.out.println(" res = " + res + ", answer = " + answer + ", n& 1 - " + (n&1) );
            n = n >> 1; // Shift n by 1 bit to the right for the next iteration.
        }
        return res;
    }
}
