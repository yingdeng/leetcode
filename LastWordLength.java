public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            }
            if (s. charAt(i) == ' ' && count != 0) {
                return count;
            }
        }
        return count;
    }
}