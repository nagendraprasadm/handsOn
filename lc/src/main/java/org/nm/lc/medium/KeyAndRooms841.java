package org.nm.lc.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeyAndRooms841
{
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        return dfs(0, rooms, visited);
    }

    public boolean dfs(int i, List<List<Integer>> rooms, Set<Integer> visited){
        if(visited.size() == rooms.size()){
            return true;
        }
        for(int j : rooms.get(i)){
            if(visited.add(j)){
                if(dfs(j, rooms, visited)){
                    return true;
                }
                //visited.remove(j);
            }
        }
        return false;
    }
}
