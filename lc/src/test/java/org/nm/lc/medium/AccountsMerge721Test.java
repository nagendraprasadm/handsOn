package org.nm.lc.medium;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountsMerge721Test extends TestCase
{
    AccountsMerge721 inst = new AccountsMerge721();

    public void testOneOne () throws Exception
    {
        List<List<String>> accounts = new ArrayList<>();
        List<String> acc1 = new ArrayList<>();
        acc1.add("John");
        acc1.add("john1@email.com");
        acc1.add("john2@email.com");
        acc1.add("john3@email.com");
        accounts.add(acc1);
        acc1 = new ArrayList<>();
        acc1.add("John");
        acc1.add("john4@email.com");
        acc1.add("john5@email.com");
        acc1.add("john6@email.com");
        accounts.add(acc1);
        acc1 = new ArrayList<>();
        acc1.add("Doe");
        acc1.add("doe1@email.com");
        acc1.add("doe2@email.com");
        accounts.add(acc1);
        acc1 = new ArrayList<>();
        acc1.add("John");
        acc1.add("john1@email.com");
        acc1.add("john7@email.com");
        acc1.add("john8@email.com");
        accounts.add(acc1);
        List<List<String>> merged = inst.accountsMergeTwo(accounts);
        assertNotNull(merged);
    }

    public void testTwoOne () throws Exception
    {
        List<List<String>> accounts = new ArrayList<>();
        List<String> acc1 = new ArrayList<>();
        acc1.add("John");
        acc1.add("johnsmith@email.com");
        acc1.add("john_newyork@email.com");
        accounts.add(acc1);
        acc1 = new ArrayList<>();
        acc1.add("John");
        acc1.add("johnsmith@email.com");
        acc1.add("john00@email.com");
        accounts.add(acc1);
        acc1 = new ArrayList<>();
        acc1.add("Mary");
        acc1.add("mary@email.com");
        accounts.add(acc1);
        acc1 = new ArrayList<>();
        acc1.add("John");
        acc1.add("johnnybravo@email.com");
        accounts.add(acc1);
        List<List<String>> merged = inst.accountsMergeTwo(accounts);
        assertNotNull(merged);
    }

    public void testTwoThree ()
    {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<>(Arrays.asList(
            new String[] { "Alex", "Alex5@m.co", "Alex4@m.co", "Alex0@m.co" })));
        accounts.add(new ArrayList<>(Arrays.asList(
            new String[] { "Ethan", "Ethan3@m.co", "Ethan3@m.co", "Ethan0@m.co" })));
        accounts.add(new ArrayList<>(Arrays.asList(
            new String[] { "Kevin", "Kevin4@m.co", "Kevin2@m.co", "Kevin2@m.co" })));
        accounts.add(new ArrayList<>(Arrays.asList(
            new String[] { "Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe2@m.co" })));
        accounts.add(new ArrayList<>(Arrays.asList(
            new String[] { "Gabe", "Gabe3@m.co", "Gabe4@m.co", "Gabe2@m.co" })));
        List<List<String>> merged = inst.accountsMergeTwo(accounts);
        assertNotNull(merged);
    }

    public void testTwoFour ()
    {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<>(Arrays.asList(
            new String[] { "David", "David0@m.co", "David4@m.co", "David3@m.co" })));
        accounts.add(new ArrayList<>(Arrays.asList(
            new String[] { "David", "David5@m.co", "David5@m.co", "David0@m.co" })));
        accounts.add(new ArrayList<>(Arrays.asList(
            new String[] { "David", "David1@m.co", "David4@m.co", "David0@m.co" })));
        accounts.add(new ArrayList<>(Arrays.asList(
            new String[] { "David", "David0@m.co", "David1@m.co", "David3@m.co" })));
        accounts.add(new ArrayList<>(Arrays.asList(
            new String[] { "David", "David4@m.co", "David1@m.co", "David3@m.co" })));
        List<List<String>> merged = inst.accountsMergeTwo(accounts);
        assertNotNull(merged);
    }
}