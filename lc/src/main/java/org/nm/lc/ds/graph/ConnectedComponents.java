package org.nm.lc.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents
{
    public List<List<Integer>> getConnectedComponents (List<Edge>[] graph)
    {
        if (graph != null && graph.length > 0) {
            List<List<Integer>> res = new ArrayList<>();
            boolean[] visited = new boolean[graph.length];
            for (int i = 0; i < graph.length; i++) {
                if (!visited[i]) {
                    List<Integer> component = new ArrayList<>();
                    dfs(i, graph, component, visited);
                    res.add(component);
                }
            }
            return res;
        }
        return null;
    }

    private void dfs (int v,
                      List<Edge>[] graph,
                      List<Integer> component,
                      boolean[] visited)
    {
        if (!visited[v]) {
            visited[v] = true;
            component.add(v);
            if (graph[v] != null) {
                for (Edge edge : graph[v]) {
                    if (!visited[edge.getTo()]) {
                        dfs(edge.getTo(), graph, component, visited);
                    }
                }
            }
            ;
        }
    }
}
