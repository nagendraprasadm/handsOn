package org.nm.lc.medium;

import java.util.ArrayList;

/**
 * CONCEPT - Grpah, Bipartite
 *
 * Should have even cycle and not add cycle.
 */
public class PossibleBiPartition886
{
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> grph = new ArrayList<>();
        for(int i = 0; i <=n; i++){
            grph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < dislikes.length; i++){
            int f = dislikes[i][0];
            int t = dislikes[i][1];
            grph.get(f).add(t);
            grph.get(t).add(f);
        }
        int[] marked = new int[n+1];
        for(int i = 1; i <=n ; i++){
            if(marked[i] == 0 && !hasOddCycle(i, 0, grph, marked)){
                return false;
            }
        }
        return true;
    }

    private boolean hasOddCycle (int v, int c, ArrayList<ArrayList<Integer>> grph, int[] marked) {
            marked[v] = c;
            for(int u : grph.get(v)){
                if(marked[u] == 0 && !hasOddCycle(u, 1-c, grph, marked)){
                    return false;
                }else if(marked[u] == c){
                    return false;
                }
            }
        return true;
    }
}
