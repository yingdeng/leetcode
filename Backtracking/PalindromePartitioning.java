/*
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return
  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        
        if (s.length() == 0 || s == null) {
            return result;
        }
        helper(s, 0, tempList, result);
        return result;
    }
    
    private boolean isPalindrome(String s) {
        int beg = 0;
        int end = s.length() - 1;
        while(beg < end) {
            if (s.charAt(beg) != s.charAt(end)) {
               return false;
            }
            beg++;
            end--;
        }
        return true;
    }
    
    private void helper(String s, int index, ArrayList<String> tempList, ArrayList<ArrayList<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<String> (tempList));
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            String str = s.substring(index, i);
            if (isPalindrome(str)) {
                list.add(str);
                helper(s, i, tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
