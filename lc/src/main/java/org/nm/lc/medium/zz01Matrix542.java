package org.nm.lc.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class zz01Matrix542
{
    private int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int[][] updateMatrix (int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                }
                else {
                    boolean[][] trk = new boolean[mat.length][mat[0].length];
                    res[i][j] = bfs(i, j, mat, trk);
                }
            }
        }
        return res;
    }

    private int bfs (int i, int j, int[][] mat, boolean[][] trk)
    {

        Queue<int[]> queue = new LinkedList<>();
        int lvl = 1;
        queue.add(new int[] { i, j });
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int k = 0; k < sz; k++) {
                int[] cell = queue.poll();
                for (int l = 0; l < dir.length; l++) {
                    int nr = cell[0] + dir[l][0];
                    int nc = cell[1] + dir[l][1];
                    if (isValid(nr, nc, mat, trk)) {
                        if (mat[nr][nc] == 0) {
                            return lvl;
                        }
                        else {
                            queue.add(new int[] { nr, nc });
                        }
                    }
                }
            }
            lvl++;
        }
        return 0;
    }

    private boolean isValid (int i, int j, int[][] mat, boolean[][] trk)
    {
        return i >= 0 && j >= 0 && i < mat.length && j < mat[0].length && !trk[i][j];
    }
}
