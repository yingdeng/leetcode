public class Solution {
    public int findMin(int[] num) {
        if (num.length == 0 || num == null) {
            return 0;
        }
        
        int left = 0;
        int right = num.length - 1;
        //int[] result = new int[0];
        
        while (num[left] > num[right]) {
            int mid = (left + right) / 2;
            if (num[mid] > num[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return num[left];
    }
}