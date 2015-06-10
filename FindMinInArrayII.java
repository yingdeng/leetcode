public class Solution {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        else if(num.length == 2) {
            return Math.min(num[0], num[1]);
        }
        
        int l = 0;
        int r = num.length - 1;
        
        while (l+1 < r) {
            int mid = (l+r) / 2;
            
            if (num[l] < num[r]) {
                return num[l];
            }
            if (num[mid] > num[l]) {
                l = mid;
            }
            else if (num[mid] < num[l]) {
                r = mid;
            }
            else {
                l++;
            }
        }
        return Math.min(num[l], num[r]);
    }
}