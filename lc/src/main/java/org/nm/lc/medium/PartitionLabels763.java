package org.nm.lc.medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels763
{
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[][] itval = new int[26][2];
        int[] trk = new int[26];
        char cur = s.charAt(0);
        itval[cur - 'a'][0] = 0;
        itval[cur - 'a'][1] = 0;
        trk[cur - 'a'] = 1;
        for(int i = 1 ; i < s.length(); i++){
            cur = s.charAt(i);
            if(trk[cur - 'a'] == 1){
                itval[cur - 'a'][1] = i;
            }else{
                trk[cur - 'a'] = 1;
                itval[cur - 'a'][0] = i;
                itval[cur - 'a'][1] = i;
            }
        }
        trk = new int[26];
        cur = s.charAt(0);
        int max = itval[cur - 'a'][1];
        trk[cur - 'a'] = 1;
        int cnt = 1;
        for(int i = 1 ; i < s.length(); i++){
            cur = s.charAt(i);
            if(trk[cur - 'a'] != 1){
                trk[cur - 'a'] = 1;
                int st = itval[cur - 'a'][0];
                int e = itval[cur - 'a'][1];
                if(e > max){
                    if(st > max){
                        res.add(cnt);
                        cnt = 1;
                    }else{
                        cnt++;
                    }
                    max = e;
                }else{
                    cnt++;
                }
            }else{
                cnt++;
            }

        }
        res.add(cnt);
        return res;
    }
}
