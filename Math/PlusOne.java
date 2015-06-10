public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            digits[i] = 1 + digits[i];
            if (digits[i] == 10) {
                digits[i] = 0;
            }
            else {
                return digits;
            }
        }
        
        // Overflow
        int[] newDigits;
        if (digits[0] == 0) {
            newDigits = new int[length + 1];
            newDigits[0] = 1;
            for (int i = 1; i < newDigits.length; i++) {
                newDigits[i] = digits[i - 1];
            }
        }
        else {
            newDigits = new int[length];
            for(int i = 0; i < newDigits.length; i++) {
                newDigits[i] = digits[i];
            }
        }
        return newDigits;
    }
}