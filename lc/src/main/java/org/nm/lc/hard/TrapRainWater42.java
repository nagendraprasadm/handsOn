package org.nm.lc.hard;

import java.util.Stack;

public class TrapRainWater42
{
    public int trap (int[] height)
    {
        Stack<Integer> stk = new Stack<>();
        int prev = height[0];
        int trap = 0;
        for (int i = 1; i < height.length; i++) {
            int cur = height[i];
            if (cur <= prev) {
                int prevH = i - 1;
                if (prev == cur && !stk.isEmpty()) {
                    prevH = stk.pop();
                }
                stk.push(prevH);
                prev = cur;
            }
            else {
                while (!stk.isEmpty() && cur > prev) {
                    int prevMaxI = stk.peek();
                    int top = Math.min(height[prevMaxI], cur);
                    int tht = top - prev;
                    int dist = i - prevMaxI - 1;
                    trap += (tht * dist);
                    prev = height[prevMaxI];
                    if(cur > prev){
                        stk.pop();
                    }
                }
                if (stk.isEmpty()) {
                    prev = cur;
                }
            }
        }
        return trap;
    }
}
