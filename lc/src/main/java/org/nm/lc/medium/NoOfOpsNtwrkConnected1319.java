package org.nm.lc.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NoOfOpsNtwrkConnected1319
{
    public int makeConnected(int n, int[][] connections) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n;i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < connections.length; i++){
            int from = connections[i][0];
            int to = connections[i][1];
            ArrayList<Integer> cur = graph.get(from);
            cur.add(to);
        }
        int cnt = 0;
        int extra = 0;
        for(int i = 0; i < n; i++){
            Set<Integer> visited = new HashSet<>();
            int conn = 0;
            if(graph.get(i).size() > 0){
                conn = dfs(i,graph, visited);
                cnt++;
            }
            extra += conn - (visited.size() > 0 ? visited.size() - 1 : 0 );
        }

        return cnt > 1 && (extra >= cnt - 1)? cnt - 1: -1;

    }

    private int dfs(int i, ArrayList<ArrayList<Integer>> graph, Set<Integer> visited){
        if(visited.add(i)){
            int conn = graph.get(i).size();
            for(int j : graph.get(i)){
                conn += dfs(j, graph, visited);
            }
            return conn;
        }
        return 0;
    }
}
