
/*
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction 
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
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
                    res[i+1] = true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return res[s.length()];
    }
}