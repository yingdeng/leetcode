public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits == null) {
            return result;
        }
        
        String[] keyboard = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int index = 0;
        StringBuilder sb = new StringBuilder();
        helper(digits, 0, sb, keyboard, result);
        return result;
    }
   
    public void helper(String digits, int index, StringBuilder sb, String[] keyboard, ArrayList<String> result) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        
        int num = digits.charAt(index)-'0';
        for (int i = 0; i < keyboard[num].length(); i++) {
            sb.append(keyboard[num].charAt(i));
            helper(digits, index+1, sb, keyboard, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

/*
private void helper(String digits, int index, StringBuilder sb, String[] keyboard, ArrayList<String> result){
      if (index==digits.length()){
         result.add(sb.toString());
         return;
         }
         
       int num=digits.charAt(index)-'0';//get integer number
       for (int i=0; i<keyboard[num].length(); i++){
         sb.append(keyboard[num].charAt(i));
         helper(digits, index+1, current, keyboard, result);
         sb.deleteCharAt(current.length()-1);
         }
     }
*/
}
