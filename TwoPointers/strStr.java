public class Solution {
    public String strStr(String haystack, String needle) {
        if(needle == null || haystack == null){
            return "";
        }
        if(haystack.length() < needle.length()){
            return null;
        }
        
        int i;
        int j;
        for(i=0; i<haystack.length()-needle.length()+1; i++){
            for(j=0; j<needle.length(); j++){
                if(needle.charAt(j) != haystack.charAt(i+j)) {
                    break;
                }
            }
            if(j == needle.length()){
                return haystack.substring(i);
            }
        }
        return null;
    }
}