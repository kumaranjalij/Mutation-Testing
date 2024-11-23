package org.example;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepetition {
    static int solve(String str) {
        if(str.length()==0)
            return 0;
        else if (str.length()==1) {
            return 1;
        }
        int maxans = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) // outer loop for traversing the string
        {
            Set< Character > se = new HashSet< >();
            for (int j = i; j < str.length(); j++) // nested loop for getting different String starting with str[i]
            {
                if (se.contains(str.charAt(j))) // if element if found so mark it as ans and break from the loop
                {
                    maxans = Math.max(maxans, j - i);
                    break;
                }
                se.add(str.charAt(j));
            }
        }
        return maxans;
    }
}
