public class Solution {
    public int threeSumClosest(int[] n, int t) {
        if (n == null || n.length < 3) {
             return Integer.MIN_VALUE;
        }
        int res = Integer.MAX_VALUE;
        Arrays.sort(n);
        for (int i = 0; i < n.length; i++) {
            int left = i+1;
            int right = n.length-1;
            while (left < right) {
                int sum = n[i] + n[left] + n[right];
                if (sum == t) {
                    return sum;
                }
                else if (sum < t) {
                    left++;
                }
                else {
                    right--;
                }
                int diff = Math.abs(sum-t) - Math.abs(res-t);
                res = diff > 0 ? res : sum;
            }
        }
        return res;
    }
}