public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] res = new int[s.length()+10];
        // init
        res[0] = 1;
        
        // Single number of s
        if (isValid(s.substring(0,1))) {
            res[1] = 1;
        }
        else {
            res[1] = 0;
        }
        
        // Two numbers of s
        for (int i = 2; i <= s.length(); i++) {
            if (isValid(s.substring(i-1, i))) {
                res[i] += res[i-1];
            }
            if (isValid(s.substring(i-2, i))) {
                res[i] += res[i-2];
            }
        }
        
        return res[s.length()];
    }
    
    public boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        int code = Integer.parseInt(s);
        return code >= 1 && code <= 26;
    } 
}