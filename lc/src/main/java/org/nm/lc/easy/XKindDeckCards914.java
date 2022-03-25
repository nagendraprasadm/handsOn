package org.nm.lc.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * In a deck of cards, each card has an integer written on it.
 *
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 *
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 *
 *
 * Example 1:
 *
 * Input: deck = [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
 * Example 2:
 *
 * Input: deck = [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition.
 *
 *
 * Constraints:
 *
 * 1 <= deck.length <= 104
 * 0 <= deck[i] < 104
 */
public class XKindDeckCards914
{
    public boolean hasGroupsSizeX (int[] deck)
    {
        Arrays.sort(deck);
        int cnt = 1;
        int prev = deck[0];
        int min = deck.length;
        for (int i = 1; i <= deck.length; i++) {
            if (i < deck.length && prev == deck[i]) {
                cnt++;
            }
            else {
                min = gcd(min, cnt);
                cnt = 1;
                prev = i < deck.length ? deck[i] : -1;
            }
        }

        return min >= 2;
    }

    private int gcd (int a, int b)
    {
        return b > 0 ? gcd(b, a % b) : a;
    }
}
