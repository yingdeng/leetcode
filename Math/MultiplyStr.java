public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null && num2 == null) {
            return null;
        }
        
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int[] num3 = new int[num1.length() + num2.length()];
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                num3[i+j] += a * b;
            }
        }
        
        for (int i = 0; i < num3.length; i++) {
            int digit = num3[i] % 10;
            int carry = num3[i] / 10;
            result.insert(0, digit);
            if (i < num3.length - 1) {
                num3[i+1] += carry;
            }
        }
        
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        
        return result.toString();
    }
}