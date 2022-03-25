package org.nm.lc.easy;

public class ReverseWordsInStringIII557
{
    public String reverseWords(String s) {
        //Stack<Character> st = new Stack<>();
        int i = 0;
        int j = 0;
        char[] resa = new char[s.length()];
        String word = "";
        while(i < s.length()){
            if(s.charAt(i) != ' '){
                //st.push(s.charAt(i));
                int ix = s.indexOf(" ", i);
                word = s.substring(i, ix == - 1? s.length() : ix);
                i = i + word.length();
            }else{
                /*while(!st.isEmpty()){
                    resa[j++] = (char)st.pop();
                }*/
                int k = word.length() - 1;
                while(k >= 0){
                    resa[j++] = word.charAt(k);
                    k--;
                }
                word = "";
                resa[j++] = ' ';
                i++;
            }

        }
        if(word.length() > 0){
            int k = word.length() - 1;
            while(k >= 0){
                resa[j++] = word.charAt(k);
                k--;
            }
        }
        return new String(resa);
    }
}
