public class Solution {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int result = 0;
        int[] bits = new int[32];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < 32; j++) {
                if ((A[i] >> j & 1) == 1) {
                    bits[j]++;
                }
            }
        }
        for (int i = 0; i < 32; i++) {
            result += (bits[i]%3 << i);
        }
        //bits = null;
        return result;
    }
}