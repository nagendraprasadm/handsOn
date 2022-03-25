package org.nm.lc.medium;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings43
{
    public String multiply(String num1, String num2) {
        List<String> products = new ArrayList<>();
        for(int i = num1.length() - 1; i >= 0 ; i--){
            StringBuilder sb = new StringBuilder();
            int n1 = Character.getNumericValue(num1.charAt(i));
            int cr = 0;
            for(int k = 1; k <= (num1.length() - 1 - i) ; k++){
                sb.append("0");
            }
            for(int j = num2.length() - 1; j >= 0 ; j--){
                int n2 = Character.getNumericValue(num2.charAt(j));
                int pr = ( n1 * n2 ) + cr;
                cr = pr / 10;
                pr = pr % 10;
                sb.append(Integer.toString(pr));
            }
            if(cr > 0){
                sb.append(Integer.toString(cr));
            }

            products.add(sb.toString());
        }

        String ps = products.get(0);
        for(int k =1 ; k <= products.size() - 1 ; k++){
            String cs = products.get(k);
            String tp = ps.length() > cs.length() ? ps : cs;
            cs = ps.length() > cs.length() ? cs : ps;
            ps = tp;
            //int i = ps.length() - 1;
            int i = 0;
            int cr = 0;
            //int diff = ps.length() - cs.length();
            StringBuilder sb = new StringBuilder();
            while(i < ps.length()){
                int n1 = Character.getNumericValue(ps.charAt(i));
                //int n2 = (i - diff < 0) ? 0 : Character.getNumericValue(cs.charAt(i - diff));
                int n2 =  i >= cs.length() ? 0 : Character.getNumericValue(cs.charAt(i));
                int s = n1 + n2 + cr;
                cr = s/10;
                s = s%10;
                sb.append(Integer.toString(s));
                i++;
            }
            if(cr > 0){
                sb.append(Integer.toString(cr));
            }
            ps = sb.toString();
        }
        ps = new StringBuilder(ps).reverse().toString();
        StringBuilder resB = new StringBuilder();
        char[] ca = ps.toCharArray();
        if(ca[0] == '0'){
            boolean found = false;
            int i = 1;
            while(i < ca.length){
                if(!found && ca[i] != '0'){
                    found = true;
                }
                if(found){
                    resB.append(ca[i]);
                }
                i++;
            }
            return !found ? "0" : resB.toString();
        }
        return ps;
    }
}
