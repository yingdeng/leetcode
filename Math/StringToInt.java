public class Solution {
    public int atoi(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        
        // Use Double to save result
        double result = 0;
        
        // Trim the whiteSpaces
        str = str.trim();
        
        // Check negative or positive
        char flag = '+';
        int i = 0;
        if (str.charAt(0) == '+') {
            i++;
        }
        else if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        }
        
        // Calculate value
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }
        
        if (flag == '-') {
            result = -result;
        }
        
        // Handle max and min
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return (int)result;
    }
}