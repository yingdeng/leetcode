public class Solution {
    public double pow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        
        if(n == 1){
            return x;
        }
        
        Boolean isNegative = false;
        if(n < 0){
            isNegative = true;
            n = -n;
        }
        
        int a = n/2;
        int b = n - a*2;
        double L1 = pow(x, a);
        double L2 = pow(x, b);
        if(isNegative){
            return 1/(L1*L1*L2);
        }else{
            return L1*L1*L2;
        }
    }
}