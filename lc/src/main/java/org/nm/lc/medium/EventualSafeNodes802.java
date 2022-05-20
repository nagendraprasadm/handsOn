package org.nm.lc.medium;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeNodes802
{
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visit = new boolean[graph.length];
        boolean[] safe = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(!visit[i]){
                dfs(i, visit, graph, safe);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i< safe.length; i++){
            if(safe[i]){
                res.add(i);
            }

        }
        return res;
    }

    private boolean dfs(int node, boolean[] visit, int[][] graph, boolean[] safe){
        if(!visit[node]){
            visit[node] = true;
            if(graph[node].length == 0){
                safe[node] = true;
                return true;
            }else{
                boolean isSafe = true;
                for(int child : graph[node]){
                    if(!dfs(child, visit, graph, safe)){
                        isSafe = false;
                    }
                }
                safe[node] = isSafe;
            }
        }
        return safe[node];
    }
}
