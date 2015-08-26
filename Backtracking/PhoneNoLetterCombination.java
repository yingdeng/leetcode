/*
Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null) {
            return result;
        }
        
        String[] keyboard = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int index = 0;
        StringBuilder sb = new StringBuilder();
        helper(digits, 0, sb, keyboard, result);
        return result;
    }
   
    public void helper(String digits, int index, StringBuilder sb, String[] keyboard, List<String> result) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        
        int num = digits.charAt(index) - '0';
        for (int i = 0; i < keyboard[num].length(); i++) {
            sb.append(keyboard[num].charAt(i));
            helper(digits, index+1, sb, keyboard, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
