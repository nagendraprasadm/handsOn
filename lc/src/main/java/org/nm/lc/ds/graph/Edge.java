package org.nm.lc.ds.graph;

import java.util.Comparator;

public class Edge
{
    private int from;

    private int to;

    private int weight;

    public Edge(int to, int weight){
        this.to = to;
        this.weight = weight;
    }

    public Edge(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int getTo ()
    {
        return to;
    }

    public int getWeight ()
    {
        return weight;
    }

    public int getFrom ()
    {
        return from;
    }

    @Override
    public String toString ()
    {
        return "Edge {" + "from -> " + from + ", to -> " + to + ", weight -> " + weight + '}';
    }
}
