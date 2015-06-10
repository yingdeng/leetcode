public class Solution {
    public boolean isPalindrome(String s){
        if(s == null){
            return false;
        }
        if(s.length() == 0){
            return true;
        }
        
        s = s.trim().toLowerCase();
        int i = 0;
        int j = s.length()-1;
        
        while(i<=j){
            
            while(i<j && !isValid(s.charAt(i))){
                i++;
            }
            while(i<j && !isValid(s.charAt(j))){
                j--;
            }
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;

        }
        return true;
    }
    
    private boolean isValid(char c){
        if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')){
            return true;
        }
        else{
            return false;
        }
    }
}