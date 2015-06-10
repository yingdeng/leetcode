public class Solution {
    public String countAndSay(int n) {
        if(n <= 0){
            return null;
        }
        
        String s = "1";
        for(int i=2; i<=n; i++){
            StringBuffer sb = new StringBuffer();
            int count = 1;
            
            for(int j=1; j<s.length(); j++){
                if(s.charAt(j) == s.charAt(j-1)){
                    count++;
                }
                else{
                    sb.append(count);
                    sb.append(s.charAt(j-1));
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(s.charAt(s.length()-1));
            s = sb.toString();
        }
         return s;
    }
   
}