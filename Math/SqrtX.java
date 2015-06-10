public class Solution {
    public int sqrt(int x) {
        long left = 0;
        long right = x;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (x < mid * mid) {
                right = mid - 1;
            }
            else if (x > mid * mid) {
                left = mid + 1;
            }
            else {
                return (int)mid;
            }
        }
        return (int)right;
    }
}