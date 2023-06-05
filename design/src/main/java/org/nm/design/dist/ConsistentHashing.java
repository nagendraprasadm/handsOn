package org.nm.design.dist;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Based on Tom White Implementation
 * @param <T>
 */
public class ConsistentHashing<T>
{
    private int noVirtualNodes;
    private List<T> nodes;
    private HashGenerator hashGenerator;
    private SortedMap<Integer, T> ring = null;

    public ConsistentHashing (List<T> nodes,
                              int noVirtualNodes,
                              HashGenerator hashGenerator)
    {
        this.nodes = nodes;
        this.noVirtualNodes = noVirtualNodes;
        this.hashGenerator = hashGenerator;
        this.ring = new TreeMap<>();
        for(T node : nodes){
            addNode(node);
        }
    }

    public void addNode (T node)
    {
        for (int i = 1; i <= noVirtualNodes; i++) {
            int hash = hashGenerator.getHash(node.toString() + i);
            ring.put(hash, node);
        }
    }

    public void remove(T node){
        for (int i = 1; i <= noVirtualNodes; i++) {
            int hash = hashGenerator.getHash(node.toString() + i);
            ring.remove(hash, node);
        }
    }

    public T getNode (String key)
    {
        int hash = hashGenerator.getHash(key);
        if (!ring.containsKey(hash)) {
            SortedMap<Integer, T> tail = ring.tailMap(hash);
            return ring.get(tail.isEmpty() ? ring.firstKey() : tail.firstKey());
        }
        return ring.get(hash);
    }

}
