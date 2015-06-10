public class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // the first string in strs is the standard
        String prefix = strs[0];
        
        for(int i = 0; i < strs.length; i++) {
            int j = 0;
            while (j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
                j++;
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
}