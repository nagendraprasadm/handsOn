package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;

public class EvaluateDivision399Test extends TestCase
{

    private EvaluateDivision399 inst = new EvaluateDivision399();

    @Test
    public void testone ()
    {
        List<List<String>> equations = new ArrayList<>();
        List<String> inp = new ArrayList<>();
        inp.add("a");
        inp.add("b");
        equations.add(inp);
        inp = new ArrayList<>();
        inp.add("b");
        inp.add("c");
        equations.add(inp);
        inp = new ArrayList<>();
        inp.add("a");
        inp.add("e");
        equations.add(inp);
        double[] values = new double[] { 2.0d, 3.0d, 4.0d };
        List<List<String>> queries = new ArrayList<>();
        inp = new ArrayList<>();
        inp.add("a");
        inp.add("c");
        queries.add(inp);
        inp = new ArrayList<>();
        inp.add("b");
        inp.add("a");
        queries.add(inp);
        inp = new ArrayList<>();
        inp.add("a");
        inp.add("e");
        queries.add(inp);
        inp = new ArrayList<>();
        inp.add("a");
        inp.add("a");
        queries.add(inp);
        inp = new ArrayList<>();
        inp.add("x");
        inp.add("x");
        queries.add(inp);
        double[] res = inst.calcEquation(equations, values, queries);
        assertTrue(res[0] == 6.0d);
    }

}