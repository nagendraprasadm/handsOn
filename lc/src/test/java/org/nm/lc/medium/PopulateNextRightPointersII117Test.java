package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class PopulateNextRightPointersII117Test extends TestCase
{
    private PopulateNextRightPointersII117 inst = new PopulateNextRightPointersII117();

    @Test
    public void testone(){
        PopulateNextRightPointersII117.Node root = new PopulateNextRightPointersII117.Node(1);
        PopulateNextRightPointersII117.Node left = new PopulateNextRightPointersII117.Node(2);
        PopulateNextRightPointersII117.Node right = new PopulateNextRightPointersII117.Node(3);
        root.left = left;
        root.right =right;
        left.left = new PopulateNextRightPointersII117.Node(4);
        left.right = new PopulateNextRightPointersII117.Node(5);

        right.right = new PopulateNextRightPointersII117.Node(7);

        assertNotNull(inst.connect(root));
    }

}