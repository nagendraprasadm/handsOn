package org.nm.lc.ds.graph;

import org.nm.lc.ds.UnionFind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MST
{
    private static final Logger logger = LoggerFactory.getLogger(MST.class);

    /**
     * -
     * 1. Get all the edges sorted by weight asc
     * 2. Iterate over minimum edges one by one
     * 2.1. Add the cur min edge to the result if this doesn't cause cycle
     * 2.2 Break the loop if the number of edges is No Of Vertices - 1
     *
     * @param graph
     * @return
     */
    public Edge[] kruskals (List<Edge>[] graph, int v)
    {
        UnionFind uf = new UnionFind(v);
        Edge[] result = new Edge[v];
        List<Edge> edges = new ArrayList<>();
        for (List<Edge> cEdges : graph) {
            edges.addAll(cEdges);
        }

        Collections.sort(edges, Comparator.comparingInt((Edge e) -> {
            return e.getWeight();
        }));

        int i = 0;
        for (Edge e : edges) {
            if (i == v) {
                break;
            }
            if (uf.find(e.getFrom()) != uf.find(e.getTo())) {
                logger.info("Adding edge from - {} and to - {} with weight - {}.",
                            e.getFrom(), e.getTo(), e.getWeight());
                uf.union(e.getFrom(), e.getTo());
                result[i++] = e;
            }
            else {
                logger.info(
                    "Edge from - {} and to - {} with weight - {} causes cycle so dropping.",
                    e.getFrom(), e.getTo(), e.getWeight());
            }
        }

        return result;
    }
}
