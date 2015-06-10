public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s == null) {
            return "";
        }
        
        String result = "";
        int maxlen = 0;
        boolean[][] list = new boolean[s.length()][s.length()];
        
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j-i <= 2 || list[i+1][j-1])) {
                    list[i][j] = true;
                    if (maxlen < j-i+1) {
                        maxlen = j-i+1;
                        result = s.substring(i, j+1);
                    }
                }
            }
        }
        return result;
    }
}