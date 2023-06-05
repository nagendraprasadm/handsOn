package org.nm.lc.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphBuilder
{

    public GraphBuilder ()
    {

    }

    /**
     * @param isDirected
     * @param noOfVertifices
     * @param edges          format {{from, to, weight},...}
     * @return
     */
    public List<Edge>[] buildAdjacencyListGraph (boolean isDirected,
                                                 int noOfVertifices,
                                                 int[][] edges)
    {
        List<Edge>[] graph = new ArrayList[noOfVertifices];
        for (int[] edge : edges) {
            List<Edge> adj = graph[edge[0]];
            if (adj == null) {
                adj = new ArrayList<>();
                graph[edge[0]] = adj;
            }
            adj.add(new Edge(edge[0], edge[1], edge[2]));
            if (!isDirected) {
                adj = graph[edge[1]];
                if (adj == null) {
                    adj = new ArrayList<>();
                    graph[edge[1]] = adj;
                }
                adj.add(new Edge(edge[1], edge[0], edge[2]));
            }
        }
        return graph;
    }
}
