package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;
import org.nm.common.ListUtil;

import java.util.ArrayList;
import java.util.List;

public class KeyAndRooms841Test extends TestCase
{

    private KeyAndRooms841 inst = new KeyAndRooms841();

    @Test
    public void testone() {
        List<List<Integer>> keys = new ArrayList<>();
        List<Integer> room1 = new ArrayList<>();
        room1.add(1);
        keys.add(room1);
        List<Integer> room2 = new ArrayList<>();
        room2.add(2);
        keys.add(room2);
        List<Integer> room3 = new ArrayList<>();
        room3.add(3);
        keys.add(room3);
        keys.add(new ArrayList<>());
        assertTrue(inst.canVisitAllRooms(keys));
    }

    @Test
    public void testtwo() {
        assertFalse(inst.canVisitAllRooms(ListUtil.fromString2D("[[1,3],[3,0,1],[2],[0]]")));
    }

    @Test
    public void testthree() {
        assertTrue(inst.canVisitAllRooms(ListUtil.fromString2D("[[2,3],[],[2],[1,3]]")));
    }
}