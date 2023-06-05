package org.nm.lc.ds.graph;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class MSTTest extends TestCase
{
    private MST inst = new MST();

    @Test
    public void testone ()
    {
        GraphBuilder graphBuilder = new GraphBuilder();
        List<Edge>[] graph = graphBuilder.buildAdjacencyListGraph(false, 4,
                                                                  new int[][] { { 0, 1, 1 }, { 0, 2, 2 },
                                                           { 1, 2, 2 }, { 1, 3, 4 },
                                                           { 2, 3, 3 } });
        Edge[] res = inst.kruskals(graph, 4);
        assertNotNull(res);
        assertEquals(4, res.length);
    }

}