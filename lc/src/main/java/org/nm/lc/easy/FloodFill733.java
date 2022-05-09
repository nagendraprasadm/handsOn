package org.nm.lc.easy;

import org.nm.lc.ds.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FloodFill733
{
    private static final Logger logger = LoggerFactory.getLogger(FloodFill733.class);

    private static final int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int origcolor = image[sr][sc];
        int[][] trk = new int[image.length][image[0].length];
        rec(image, sr,sc,origcolor, newColor, trk, 1);
        return image;
    }

    private void rec(int[][] image, int i, int j, int oc, int nc, int[][] trk, int lvl){
        if(isValid(i,j, image) ){
            //trk[i][j] = 1;
            int cc = image[i][j];
            logger.info("{} Index - [{},{}], oc - {}, nc - {}, trk - {}", StringUtil.getHyphens(lvl), i, j, oc, nc, trk);
            if(cc == oc) {
                image[i][j] = nc;
                for(int k = 0; k < 4; k++){
                    rec(image, i + dir[k][0], j + dir[k][1], oc, nc, trk, lvl + 1);
                }
            }
        }
    }

    private boolean isValid(int i, int j, int[][] image){
        return i >= 0 && j >= 0 && i < image.length && j < image[0].length;
    }
}
