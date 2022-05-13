package org.nm.lc.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Min Possible using Queue
 *
 * RETRY
 */
public class AsFarFromLandPossible1162
{
    private int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int maxDistance (int[][] grid)
    {
        boolean[][] trk = new boolean[grid.length][grid[0].length];

        Queue<Integer[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Integer[] { i, j });
                }
            }
        }
        if (queue.size() == 0) {
            return -1;
        }
        else {
            int size = queue.size();
            int lvl = 0;
            while (!queue.isEmpty()) {
                for (int i = 0; i < size; i++) {
                    Integer[] box = queue.poll();
                    trk[box[0]][box[1]] = true;
                    for (int j = 0; j < dir.length; j++) {
                        int nr = box[0] + dir[j][0];
                        int nc = box[1] + dir[j][1];
                        if (isValid(nr, nc, grid, trk)) {
                            trk[nr][nc] = true;
                            queue.add(new Integer[] { nr, nc });
                        }
                    }
                }
                lvl++;
                size = queue.size();
            }
            return lvl - 1;
        }
    }

    private boolean isValid (int i, int j, int[][] grid, boolean[][] trk)
    {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length
            && grid[i][j] == 0 && !trk[i][j];
    }

}
