public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0 && divisor == 0) {
            return 0;
        }
        
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor <0);
        
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        
        long sum = 0;
        long pow = 0;
        long result = 0;
        while (a >= b) {
            sum = b;
            pow = 1;
            while (a >= sum) {
                result += pow;
                a -= sum;
                
                //sum <<= 1;
                //pow <<= 1;
            
                sum += sum;
                pow += pow;
            }
        }
        //result = isNegative ? - result : result;
        result = (((dividend^divisor) >> 31) & 1) == 1 ? -result : result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        
        return (int)result;
    }
}