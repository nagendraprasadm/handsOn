package org.nm.lc.medium;

import java.util.*;

/**
 * Given a list of accounts where each element accounts[i] is a list of strings,
 * where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person
 * if there is some common email to both accounts.
 * Note that even if two accounts have the same name,
 * they may belong to different people as people could have the same name.
 * A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 * After merging the accounts, return the accounts in the following format:
 * the first element of each account is the name, and the rest of the elements are emails in sorted order.
 * The accounts themselves can be returned in any order.
 */
public class AccountsMerge721
{
    public List<List<String>> accountsMergeOne (List<List<String>> accounts)
    {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<List<String>>> nameToEmailsList = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> curAcc = accounts.get(i);
            String name = curAcc.get(0);
            if (!nameToEmailsList.containsKey(name)) {
                nameToEmailsList.put(name, new ArrayList<>());
            }
            List<List<String>> emailList = nameToEmailsList.get(name);
            emailList.add(curAcc.subList(1, curAcc.size()));
        }
        int prevGroup = 0;
        for (String accName : nameToEmailsList.keySet()) {
            List<List<String>> emailsList = nameToEmailsList.get(accName);
            Map<String, Integer> emailsToGroup = new TreeMap<>();
            Map<Integer, Integer> indexToGrp = new HashMap<>();
            int groupNo = prevGroup;
            for (int i = 0; i < emailsList.size(); i++) {
                List<String> emails = emailsList.get(i);
                for (int j = 0; j < emails.size(); j++) {
                    String curEmail = emails.get(j);
                    if (emailsToGroup.containsKey(curEmail)) {
                        int grpIx = emailsToGroup.get(curEmail);
                        indexToGrp.put(i, grpIx);
                    }
                    else {
                        if (indexToGrp.containsKey(i)) {
                            emailsToGroup.put(curEmail, indexToGrp.get(i));
                        }
                        else {
                            int newGrp = groupNo++;
                            emailsToGroup.put(curEmail, newGrp);
                            indexToGrp.put(i, newGrp);
                        }
                    }
                }
            }
            for (int i = prevGroup; i < groupNo; i++) {
                List<String> acc = new ArrayList<>();
                acc.add(accName);
                result.add(acc);
            }
            for (String email : emailsToGroup.keySet()) {
                int group = emailsToGroup.get(email);
                List<String> acc = result.get(group);
                acc.add(email);
            }
            prevGroup = groupNo;
        }
        return result;
    }

    public List<List<String>> accountsMergeTwo (List<List<String>> accounts)
    {
        List<List<String>> result = new ArrayList<>();
        int prevGroup = 0;
        Map<String, Map<String, Integer>> accEmailsToGroup = new HashMap<>();
        Map<String, Map<Integer, Integer>> accIndexToGroup = new HashMap<>();
        Map<Integer, String> groupToAcc = new HashMap<>();
        for (int j = 0; j < accounts.size(); j++) {
            List<String> accEmails = accounts.get(j);
            String accName = accEmails.get(0);
            Map<String, Integer> emailsToGroup = accEmailsToGroup.get(accName);
            if (emailsToGroup == null) {
                emailsToGroup = new TreeMap<>();
                accEmailsToGroup.put(accName, emailsToGroup);
            }
            Map<Integer, Integer> indexToGrp = accIndexToGroup.get(accName);
            if (indexToGrp == null) {
                indexToGrp = new HashMap<>();
                accIndexToGroup.put(accName, indexToGrp);
            }
            int groupNo = prevGroup;
            for (int i = 1; i < accEmails.size(); i++) {
                String curEmail = accEmails.get(i);
                if (emailsToGroup.containsKey(curEmail)) {
                    int ix = emailsToGroup.get(curEmail);
                    int grp = indexToGrp.get(ix);
                    if (indexToGrp.containsKey(j) && grp < indexToGrp.get(j)) {
                        groupToAcc.remove(indexToGrp.get(j));
                        groupNo = prevGroup;
                    }
                    indexToGrp.put(j, indexToGrp.get(ix));
                }
                else {
                    emailsToGroup.put(curEmail, j);
                    if (!indexToGrp.containsKey(j)) {
                        int newGrp = groupNo++;
                        groupToAcc.put(newGrp, accName);
                        indexToGrp.put(j, newGrp);
                    }
                }

            }
            prevGroup = groupNo;
        }
        for (int i = 0; i < prevGroup; i++) {
            List<String> acc = new ArrayList<>();
            acc.add(groupToAcc.get(i));
            result.add(acc);
        }
        for (String accName : accEmailsToGroup.keySet()) {
            Map<String, Integer> emailsToGroup = accEmailsToGroup.get(accName);
            Map<Integer, Integer> ixToGrp = accIndexToGroup.get(accName);
            for (String email : emailsToGroup.keySet()) {
                int ix = emailsToGroup.get(email);
                int grp = ixToGrp.get(ix);
                List<String> acc = result.get(grp);
                acc.add(email);
            }
        }
        return result;
    }
}
