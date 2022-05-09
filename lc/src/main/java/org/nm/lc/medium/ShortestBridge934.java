package org.nm.lc.medium;

import org.apache.commons.lang3.ArrayUtils;
import org.nm.lc.ds.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShortestBridge934
{
    private static final Logger logger = LoggerFactory.getLogger(ShortestBridge934.class);

    int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    int mind = Integer.MAX_VALUE;

    public int shortestBridge (int[][] grid)
    {
        int iscnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid, iscnt);
                    iscnt++;
                }
            }
        }
        mind = Math.max(grid.length, grid[0].length);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 3) {
                    int cdist = findMin(i, j, grid, 0);
                    mind = Math.min(cdist, mind);
                }
            }
        }
        return mind;
    }

    private boolean dfs (int i, int j, int[][] grid, int cnt)
    {

        if (isValid2(i, j, grid) && grid[i][j] == 0) {
            return true;
        }
        if (isValid(i, j, grid)) {
            int val = grid[i][j];
            boolean isBorder = false;
            grid[i][j] = -1;

            for (int k = 0; k < 4; k++) {
                int ni = i + dir[k][0];
                int nj = j + dir[k][1];
                boolean borderResp = dfs(ni, nj, grid, cnt);
                isBorder = !isBorder && borderResp ? true : isBorder;
            }

            if (isBorder) {
                grid[i][j] = cnt == 0 ? 3 : 4;
            }
            else {
                grid[i][j] = cnt == 0 ? 5 : 6;
            }

        }
        return false;
    }

    private int findMin (int i, int j, int[][] grid, int dist)
    {
        if (isValid2(i, j, grid) && dist <= mind) {
            if (grid[i][j] == 0 || (grid[i][j] == 3 && dist == 0)) {
                int val = grid[i][j];
                grid[i][j] = -1;
                for (int k = 0; k < 4; k++) {
                    int ni = i + dir[k][0];
                    int nj = j + dir[k][1];
                    int cdist = findMin(ni, nj, grid, dist + 1);
                    mind = Math.min(cdist, mind);

                }
                logger.info(
                    "{}, Index - [{}, {}],   mind - {}",
                    StringUtil.getHyphens(dist), i, j, mind);
                grid[i][j] = val;
                return mind;
            }
            else if (grid[i][j] == 4) {
                return dist - 1;
            }
        }
        return Math.max(grid.length, grid[0].length);
    }

    private boolean isValid (int i, int j, int[][] grid)
    {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length
            && grid[i][j] == 1;
    }

    private boolean isValid2 (int i, int j, int[][] grid)
    {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
}
