package org.nm.lc.medium;

import org.nm.lc.ds.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class TimeNeedInformAllEmpl1376
{
    private Logger logger = LoggerFactory.getLogger(TimeNeedInformAllEmpl1376.class);

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> hier = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++){
            hier.add(new ArrayList<Integer>());
        }
        for(int i =0;i < manager.length; i++){
            if(manager[i] != -1){
                hier.get(manager[i]).add(i);
            }
        }

        boolean[] visited = new boolean[n];
        return dfs(headID, hier, visited, informTime,1);
    }

    private int dfs(int emp, ArrayList<ArrayList<Integer>> hier, boolean[] visited, int[] time, int lvl){
        if(!visited[emp]){
            visited[emp] = true;
            int ttltime = 0;
            for(int rep : hier.get(emp)){
                ttltime = Math.max(dfs(rep, hier, visited, time, lvl + 1), ttltime);
            }
            logger.info("{} Time Taken for manager - {} is - {}", StringUtil.getHyphens(lvl), emp, ttltime + time[emp]);
            return ttltime + time[emp];
        }
        return 0;
    }
}
