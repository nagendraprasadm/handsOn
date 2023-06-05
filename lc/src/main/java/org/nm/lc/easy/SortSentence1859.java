package org.nm.lc.easy;

public class SortSentence1859
{
    public String sortSentence (String s)
    {
        String[] words = s.split(" ");
        String[] reswords = new String[words.length];
        for (String word : words) {
            int i = Character.getNumericValue(word.charAt(word.length() - 1));
            reswords[i-1] = word.substring(0, word.length() - 1);
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            res.append(reswords[i]);
            if (i < words.length - 1) {
                res.append(" ");
            }
        }

        return res.toString();

    }
}
