package org.nm.lc.easy;

public class ImageSmoother661
{
    public int[][] imageSmoother (int[][] img)
    {

        int rl = img.length;
        int cl = img[0].length;
        int[][] avgs = new int[rl][cl];

        for (int i = 0; i < img.length; i++) {

            for (int j = 0; j < img[0].length; j++) {
                double csum = 0;
                int cnt = 0;
                if (i - 1 > -1) {
                    if (j - 1 > -1) {
                        cnt++;
                        csum += img[i - 1][j - 1];
                    }
                    csum += img[i - 1][j];
                    cnt++;
                    if (j + 1 < cl) {
                        csum += img[i - 1][j + 1];
                        cnt++;
                    }
                }

                if (j - 1 > -1) {
                    cnt++;
                    csum += img[i][j - 1];
                }
                csum += img[i][j];
                cnt++;
                if (j + 1 < cl) {
                    csum += img[i][j + 1];
                    cnt++;
                }

                if (i + 1 < rl) {
                    if (j - 1 > -1) {
                        cnt++;
                        csum += img[i + 1][j - 1];
                    }
                    csum += img[i + 1][j];
                    cnt++;
                    if (j + 1 < cl) {
                        csum += img[i + 1][j + 1];
                        cnt++;
                    }
                }

                avgs[i][j] = new Double(Math.floor(csum/cnt)).intValue();
            }

        }
        return avgs;
    }
}
