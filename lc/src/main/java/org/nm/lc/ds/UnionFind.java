package org.nm.lc.ds;

public class UnionFind
{
    private int[] parent;
    private int[] rank;

    public UnionFind (int size)
    {
        this.parent = new int[size + 1];
        this.rank = new int[size + 1];
        for (int i = 0; i < size + 1; i++) {
            this.parent[i] = i;
        }
    }

    public int find (int x)
    {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union (int x, int y)
    {
        int px = find(x);
        int py = find(y);
        if(px == py){
            return false;
        }
        if (rank[px] > rank[py]) {
            parent[py] = px;
        }
        else if (rank[px] < rank[py]) {
            parent[px] = py;
        }
        else {
            rank[px] = rank[px] + 1;
            parent[py] = px;
        }
        return true;
    }
}
