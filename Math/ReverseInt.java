public class Solution {
    public int reverse(int x) {
        long num = x;
        long rev = 0;
        int sign = 1;
        
        if (x < 0) {
            sign = -1;
            num = -num;
        }
        
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        
        if (rev > Integer.MAX_VALUE) {
            return 0;
        }
        else {
            return sign * (int)rev;
        }
    }
}