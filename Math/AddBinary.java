public class Solution {
    public String addBinary(String a, String b) {
         if(a.length() < b.length()){
             String temp = a;
             a = b;
             b = temp;
         }
         
         int i = a.length()-1;
         int j = b.length()-1;
         int carry = 0;
         
         StringBuffer result = new StringBuffer();
         
         while(i>=0 && j>=0){
             int sum = (int)(a.charAt(i)-'0')+(int)(b.charAt(j)-'0')+carry;
             int digit = sum%2;
             carry = sum/2;
             result.append(digit);
             i--;
             j--;
         }
         while(i>=0){
             int sum = (int)(a.charAt(i)-'0')+carry;
             int digit = sum%2;
             carry = sum/2;
             result.append(digit);
             i--;
         }
        
         if(carry==1){
             result.append(carry);
         }
         return result.reverse().toString();
    }
}