package org.nm.lc.medium;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

/**
 * RETRY
 *
 * Catch is figuring our the max length it can reach. furth.
 *
 * Ref - https://leetcode.com/problems/minimum-jumps-to-reach-home/discuss/978357/C%2B%2B-bidirectional-BFS-solution-with-proof-for-search-upper-bound
 */
public class MinJumpsReachHome1654
{
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        List<Integer> forarr = Arrays.stream(forbidden).boxed().collect(Collectors.toList());
        int lvl = 0;
        Queue<Pair<Integer,Boolean>> queue = new LinkedList<>();
        queue.add(new Pair(0,false));
        Set<Integer> seenF = new HashSet<>();
        seenF.add(0);
        Set<Integer> seenB = new HashSet<>();
        int furth = 4000 + a + b;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair<Integer, Boolean> posPair = queue.poll();
                if(posPair.getKey() == x){
                    return lvl;
                }
                Integer next_pos = posPair.getKey() + a;
                if(next_pos <= furth && !forarr.contains(next_pos) && !seenF.contains(next_pos)){
                    queue.add(new Pair(next_pos,false));
                    seenF.add(next_pos);
                }
                if(!posPair.getValue()){
                    next_pos = posPair.getKey() - b;
                    if(next_pos >= 0 && !forarr.contains(next_pos) && !seenB.contains(next_pos) ){
                        queue.add(new Pair(next_pos,true));
                        seenB.add(next_pos);
                    }
                }

            }
            lvl++;
        }


        return -1;

    }
}
