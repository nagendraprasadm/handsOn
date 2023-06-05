package org.nm.lc.medium;

import java.util.*;

public class EvaluateDivision399
{
    public double[] calcEquation (List<List<String>> equations,
                                  double[] values,
                                  List<List<String>> queries)
    {
        UnionFind uf = new UnionFind();
        Map<String, List<Edge>> grp = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            uf.union(equation.get(0), equation.get(1));
            Edge edge = new Edge(equation.get(1), values[i]);
            List<Edge> adj = null;
            if (!grp.containsKey(equation.get(0))) {
                grp.put(equation.get(0), new ArrayList<Edge>());
            }
            adj = grp.get(equation.get(0));
            adj.add(edge);
            adj = null;
            edge = new Edge(equation.get(0), 1 / values[i]);
            if (!grp.containsKey(equation.get(1))) {
                grp.put(equation.get(1), new ArrayList<Edge>());
            }
            adj = grp.get(equation.get(1));
            adj.add(edge);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);

            if (grp.containsKey(from) && uf.find(from).equals(uf.find(to))) {
                if (from.equals(to)) {
                    res[i] = 1;
                }
                else {
                    Queue<Edge> queue = new ArrayDeque<>();
                    for (Edge curEdge : grp.get(from)) {
                        queue.add(curEdge);
                    }
                    while (!queue.isEmpty()) {
                        Edge edge = queue.poll();
                        if (edge.to.equals(to)) {
                            res[i] = edge.weight;
                            break;
                        }
                        else {
                            for (Edge curEdge : grp.get(edge.to)) {
                                if(!curEdge.to.equals(from)){
                                    Edge newEdge = new Edge(curEdge.to,
                                                            edge.weight * curEdge.weight);
                                    queue.add(newEdge);
                                }
                            }

                        }
                    }
                    if (res[i] == 0) {
                        res[i] = -1;
                    }
                }
            }
            else {
                res[i] = -1;
            }

        }

        return res;
    }

    public class Edge
    {

        public double weight;
        public String to;

        public Edge (String to, double weight)
        {
            this.weight = weight;
            this.to = to;
        }

    }

    public class UnionFind
    {
        private Map<String, String> parent;

        public UnionFind ()
        {
            this.parent = new HashMap<>();
        }

        public String find (String from)
        {
            if (parent.containsKey(from)) {
                if (!parent.get(from).equals(from)) {
                    parent.put(from, find(parent.get(from)));
                }
            }
            else {
                parent.put(from, from);
            }
            return parent.get(from);
        }

        public void union (String from, String to)
        {
            parent.put(find(from), find(to));
        }

    }
}
