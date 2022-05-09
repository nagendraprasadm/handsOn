package org.nm.lc.ds;

public class StringUtil
{

    public static String getHyphens(int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            sb.append(" - ");
        }
        return sb.toString();
    }
}
