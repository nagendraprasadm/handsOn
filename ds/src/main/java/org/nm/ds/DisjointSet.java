package org.nm.ds;

/**
 * --
 * This data structure is used to combine different components into one.
 * Main operations :
 * - Find the Root of the current element
 * - Union two elements into one
 */
public class DisjointSet
{

    private int[] representatives = null;

    public DisjointSet (int capacity)
    {
        representatives = new int[capacity];
        /*
        Initially an element is the representative of itself.
         */
        for (int i = 0; i < capacity; i++) {
            representatives[i] = i;
        }
    }

    public int findRoot (int element)
    {
        if (representatives[element] == element) {
            return element;
        }
        return findRoot(representatives[element]);
    }

    /**
     * In this by default we make the parent of first element
     * as the parent of second element.
     *
     * @param elementOne
     * @param elementTwo
     */
    public void union (int elementOne, int elementTwo)
    {
        representatives[elementOne] = representatives[elementTwo];
    }
}
