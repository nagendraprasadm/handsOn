package org.nm.lc.medium;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections986
{
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        if(firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0){
            return new int[][]{};
        }else{
            int fi = 0;
            int si = 0;

            List<List<Integer>> resL = new ArrayList<>();

            while(fi < firstList.length && si < secondList.length){

                int fmin = firstList[fi][0];
                int fmax = firstList[fi][1];
                int smin = secondList[si][0];
                int smax = secondList[si][1];
                int min = -1;
                int max = -1;
                boolean found = false;

                if(fmin > smax){
                    si++;
                }else if (smin > fmax){
                    fi++;
                }else if(fmin <= smin &&  fmax >= smin){
                    found = true;
                    min = Math.max(fmin, smin);
                    max = Math.min(smax, fmax);

                    if(smax >= fmax){
                        fi++;
                    }else{
                        si++;
                    }
                }else if(smin <= fmin && smax >= fmin){
                    found = true;
                    min = Math.max(smin, fmin);
                    max = Math.min(smax, fmax);
                    if(fmax >= smax){
                        si++;
                    }else{
                        fi++;
                    }
                }else if(smin  == fmin && smax == fmax){
                    found = true;
                    min = smin;
                    max = smax;
                    si++;
                    fi++;
                }

                if(found){
                    List<Integer> cur = new ArrayList<>();
                    cur.add(min);
                    cur.add(max);
                    resL.add(cur);
                }

            }

            if(resL.size() > 0){
                int[][] res = new int[resL.size()][2];
                int i = 0;
                for(List<Integer> item : resL){
                    res[i++] = new int[]{item.get(0), item.get(1)};
                }
                return res;
            }
            return new int[][]{};
        }



    }
}
