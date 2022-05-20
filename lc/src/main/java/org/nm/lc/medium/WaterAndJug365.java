package org.nm.lc.medium;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WaterAndJug365
{
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        //Pair<Integer, Integer> capacity = new Pair<Integer, Integer>();
        if(jug2Capacity > jug1Capacity){
            int temp = jug1Capacity;
            jug1Capacity = jug2Capacity;
            jug2Capacity = temp;
        }
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(jug1Capacity, 0));
        queue.add(new Pair(0, jug2Capacity));
        Set<String> visited = new HashSet<>();
        visited.add(jug1Capacity + "-" + 0);
        visited.add(0 + "-" + jug2Capacity);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair<Integer, Integer> pair = queue.poll();
                int jug1q = pair.getKey();
                int jug2q = pair.getValue();
                if(jug1q == targetCapacity || jug2q == targetCapacity || (jug1q + jug2q) == targetCapacity){
                    return true;
                }
                int n1q = jug1q;
                int n2q = jug2q;
                if(n1q > 0 && visited.add(n1q + "-" + 0)){
                    queue.add(new Pair(n1q, 0));
                }
                if(n2q > 0 && visited.add(0 + "-" + n2q)){
                    queue.add(new Pair(0, n2q));
                }
                if(visited.add(n1q + "-" + jug2Capacity)){
                    queue.add(new Pair(n1q, jug2Capacity));
                }
                if(visited.add(jug1Capacity + "-" + n2q)){
                    queue.add(new Pair(jug1Capacity, n2q));
                }
                int ttlq = jug1q + jug2q;
                n2q = ttlq >= jug2Capacity ? jug2Capacity : ttlq;
                n1q = ttlq >= jug2Capacity ? ttlq - jug2Capacity : 0;
                if(visited.add(n1q + "-" + n2q)){
                    queue.add(new Pair(n1q, n2q));
                }
                n1q = 0;
                if(n2q > 0 && visited.add(n1q + "-" + n2q)){
                    queue.add(new Pair(n1q, n2q));
                }
                n2q = ttlq >= jug1Capacity ? ttlq - jug1Capacity : 0;
                n1q = ttlq >= jug1Capacity ? jug1Capacity : ttlq;
                if(visited.add(n1q + "-" + n2q)){
                    queue.add(new Pair(n1q, n2q));
                }
                n1q = 0;
                if(n2q > 0 && visited.add(n1q + "-" + n2q)){
                    queue.add(new Pair(n1q, n2q));
                }
            }
        }
        return false;

    }
}
