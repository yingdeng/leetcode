public class Solution {
    public int findPeakElement(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return 0;
        }
        if (num.length == 2) {
            return num[0] > num[1] ? 0 : 1;
        }
        int left = 0;
        int right = num.length - 1;
        int mid = 0;
        while (left+1 < right) {
            mid = left + (right - left) / 2;
            if (num[mid] > num[mid+1] && num[mid] > num[mid-1]) {
                return mid;
            }
            else if (num[mid] > num[mid-1] && num[mid] < num[mid+1] ){
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return num[left] > num[right] ? left : right;
    }
}