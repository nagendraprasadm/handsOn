package org.nm.lc.easy;

public class ValidPalindromeII680
{
    public boolean validPalindrome (String s)
    {

        int targetix = s.length() / 2;
        int rixS = s.length() % 2 == 0 ? targetix : targetix + 1;
        int cnt = 0;
        int fix = 0;
        int rix = s.length() - 1;
        while (fix < targetix && rix >= rixS) {
            if (s.charAt(fix) != s.charAt(rix)) {
                if (s.charAt(fix + 1) == s.charAt(rix)) {
                    fix++;
                    cnt++;
                    if (cnt > 1) {
                        break;
                    }
                    targetix = (s.length() - 1) / 2;
                    rixS = (s.length() - 1) % 2 == 0 ? targetix : targetix + 1;
                   // continue;
                }
                else if (s.charAt(fix) == s.charAt(rix - 1)) {
                    rix--;
                    cnt++;
                    if (cnt > 1) {
                        break;
                    }
                    targetix = (s.length() - 1) / 2;
                    rixS = (s.length() - 1) % 2 == 0 ? targetix : targetix + 1;
                    //continue;
                }
                else {
                    return false;
                }
            }
            fix++;
            rix--;
        }
        return cnt <= 1;
    }
}
