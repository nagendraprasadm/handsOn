package org.nm.lc.ds.graph;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class ConnectedComponentsTest extends TestCase
{
    private ConnectedComponents inst = new ConnectedComponents();

    @Test
    public void testone ()
    {
        GraphBuilder graphBuilder = new GraphBuilder();
        List<Edge>[] graph = graphBuilder.buildAdjacencyListGraph(false, 3, new int[][] {
            { 0, 1, 1 }, { 0, 2, 2 } });
        List<List<Integer>> components = inst.getConnectedComponents(graph);
        assertNotNull(components);
        assertEquals(1, components.size());
    }

    @Test
    public void testtwo ()
    {
        GraphBuilder graphBuilder = new GraphBuilder();
        List<Edge>[] graph = graphBuilder.buildAdjacencyListGraph(false, 5, new int[][] {
            { 0, 1, 1 }, { 0, 2, 2 }, { 3, 4, 4 } });
        List<List<Integer>> components = inst.getConnectedComponents(graph);
        assertNotNull(components);
        assertEquals(2, components.size());
    }

}