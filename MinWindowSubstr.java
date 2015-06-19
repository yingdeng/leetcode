/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

public class Solution {
    public String minWindow(String S, String T) {
        if (S == null || S.length() == 0 || T == null || T.length() == 0) {
            return null;
        }
        
        HashMap<Character, Integer> dict = new HashMap<>();
        char[] charT = T.toCharArray();
        for (int i = 0; i < charT.length; i++) {
            if (!dict.containsKey(charT[i])) {
                dict.put(charT[i], 1);
            }
            else {
                dict.put(charT[i], dict.get(charT[i])+1);
            }
        }
        
        int minLen = S.length()+1;
        int left = 0;
        int strPos = 0;
        int count = 0;
        char[] charS = S.toCharArray();
        for (int i = 0; i < charS.length; i++) {
            if (dict.containsKey(charS[i])) {
                dict.put(charS[i], dict.get(charS[i])-1);
                if (dict.get(charS[i]) >= 0) {
                    count++;
                }
                
                while (count == T.length()) {
                    if (minLen > i-left+1) {
                        minLen = i-left+1;
                        strPos = left;
                    }
                    if (dict.containsKey(charS[left])) {
                        dict.put(charS[left], dict.get(charS[left])+1);
                        if (dict.get(charS[left]) > 0) {
                            /*if (minLen > i-left+1) {
                               minLen = i-left+1;
                               strPos = left;
                            }*/
                            count--;
                       }
                   }
                   left++;
                }
            }
        }
        if (minLen > S.length()) {
            return "";
        }
        return S.substring(strPos, strPos+minLen); 
    }
}