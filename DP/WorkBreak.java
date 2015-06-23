/*
Work Break
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

The key to solve this problem by using dynamic programming approach:
1. Define an array t[] such that t[i]==true => 0-(i-1) can be segmented using dictionary
2. Initial state t[0] == true
*/

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0 || s == null) {
            return true;
        }
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder str = new StringBuilder(s.substring(0, i+1));
            for (int j = 0; j <= i; j++) {
                if (res[j] && dict.contains(str.toString())) {
                    res[i + 1] = true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return res[s.length()];
    }
}
