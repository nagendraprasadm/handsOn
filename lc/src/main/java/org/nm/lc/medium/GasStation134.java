package org.nm.lc.medium;

import java.util.ArrayList;
import java.util.List;

public class GasStation134
{
    public int canCompleteCircuit(int[] gas, int[] cost) {
        List<Integer> start = new ArrayList<>();
        for(int i = 0; i< gas.length; i++){
            if(gas[i] >= cost[i]){
                start.add(i);
            }
        }

        if(start.size() > 0){
            for(int s : start){
                int cg = gas[s];
                int cc = cost[s];
                int j = (s + 1 + gas.length)%gas.length;
                while(j != s){
                    cg = cg - cc + gas[j];
                    cc = cost[j];
                    if(cc > cg){
                        break;
                    }
                    j = (j + 1 + gas.length)%gas.length;
                }
                if(j == s){
                    return s;
                }
            }
        }
        return -1;
    }
}
