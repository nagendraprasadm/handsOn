package org.nm.lc.easy;

public class FindPathExistsInGraph1971
{
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(n == 1){
            return true;
        }
        if(edges.length > 0){
            int[][] grp = new int[n][n];
            for(int i = 0; i < edges.length; i++){
                int s = edges[i][0];
                int t = edges[i][1];
                grp[s][t] = 1;
            }
            return dfs(source, destination, new boolean[n], grp);
        }
        return false;
    }

    private boolean dfs(int s, int t, boolean[] trk, int[][] g){
        if(!trk[s]){
            trk[s] = true;
            if(s == t){
                return true;
            }
            for(int i = 0; i < g.length; i++){
                if(s != i && (g[s][i] == 1 || g[i][s] == 1)){
                    if(dfs(i, t, trk,g)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
