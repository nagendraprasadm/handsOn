package org.nm.lc.medium;

import org.nm.lc.ds.UnionFind;

public class RedundantConnection684
{
    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        UnionFind unionFind = new UnionFind(edges.length - 1);
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(unionFind.find(u) != unionFind.find(v)){
                unionFind.union(u, v);
            }else{
                res = edges[i];
            }
        }
        return res;
    }
}
