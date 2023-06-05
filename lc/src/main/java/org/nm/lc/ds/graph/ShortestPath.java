package org.nm.lc.ds.graph;

import java.util.*;

public class ShortestPath
{
    /**
     * Approach:
     * 1. Track distances of all the reaching vertices, holding on to the minimum value
     * 2. Start from source
     * 2.1 Navigate through all the adjacent edges, tracking the minimum
     * 2.2. Continue with other adjacent edges of the visited edges
     *
     * @param graph
     */
    public int[] dijkstra (List<Edge>[] graph, int s)
    {
        int[] d = new int[graph.length];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[s] = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return d[a] - d[b];
        });
        queue.add(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (graph[v] != null) {
                for (Edge e : graph[v]) {
                    int dist = d[v] + e.getWeight();
                    if (d[e.getTo()] > dist) {
                        d[e.getTo()] = dist;
                        queue.add(e.getTo());
                    }
                }
            }
        }
        return d;
    }
}
