package org.nm.lc.medium;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals56
{
    public int[][] merge (int[][] intervals)
    {
        List<List<Integer>> res = sort(intervals, 0, intervals.length - 1);
        int[][] out = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            out[i][0] = res.get(i).get(0);
            out[i][1] = res.get(i).get(1);
        }
        return out;
    }

    private List<List<Integer>> sort (int[][] inp, int s, int e)
    {
        if (s == e) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            temp.add(inp[s][0]);
            temp.add(inp[s][1]);
            res.add(temp);
            return res;
        }
        else if (s < e) {
            int mid = s + (e - s) / 2;
            List<List<Integer>> fh = sort(inp, s, mid);
            List<List<Integer>> sh = sort(inp, mid + 1, e);
            return merge(fh, sh);
        }
        return new ArrayList<>();
    }

    private List<List<Integer>> merge (List<List<Integer>> fh, List<List<Integer>> sh)
    {
        int i = 0;
        int j = 0;
        List<List<Integer>> res = new ArrayList<>();
        int le = -1;
        while (i < fh.size() && j < sh.size()) {
            List<Integer> first = fh.get(i);
            List<Integer> second = sh.get(j);
            int fs = first.get(0);
            int fe = first.get(1);
            int ss = second.get(0);
            int se = second.get(1);
            List<Integer> temp = new ArrayList<>();
            if(fe <= le){
                i++;
            }else if(se <= le){
                j++;
            }
            else if (ss > fe) {
                //res.add(first);
                temp = first;
                i++;
            }
            else if (fs > se) {
                //res.add(second);
                temp = second;
                j++;
            }
            else if (fs <= ss && se >= fe) {
                //3,5
                /*List<Integer> temp = new ArrayList<>();
                temp.add(fs);
                temp.add(se);
                res.add(temp);*/
                temp.add(fs);
                temp.add(se);
                i++;
                j++;
            }
            else if (fs < ss && fe > se) {
                //4
                //res.add(first);
                temp = first;
                i++;
                j++;

            }
            else if (ss <= fs && fe >= se) {
                //2
               /* List<Integer> temp = new ArrayList<>();
                temp.add(ss);
                temp.add(fe);
                res.add(temp);*/
                temp.add(ss);
                temp.add(fe);
                i++;
                j++;
            }
            else if (ss < fs && se > fe) {
                //4
                //res.add(second);
                temp = second;
                i++;
                j++;
            }

            if(res.isEmpty()){
                res.add(temp);
            }else if(!temp.isEmpty()){
                le = res.get(res.size() - 1).get(1);
                if(temp.get(0) > le){
                    res.add(temp);
                }else if(temp.get(1) > le){
                    res.get(res.size() - 1).set(1, temp.get(1));
                }
            }
            le = res.size() > 0 ? res.get(res.size() - 1).get(1) : -1;
        }
        int st = i == fh.size() ? j : i;
        fh = i == fh.size() ? sh : fh;

        while(st < fh.size()){
            int fs = fh.get(st).get(0);
            int fe = fh.get(st).get(1);
            if(fe > le){
                if(fs <= le){
                    res.get(res.size() - 1).set(1, fe);
                }else if (fs > le){
                    res.add(fh.get(st));
                }
                le = fe;
            }
            st++;
        }
        return res;
    }
}
