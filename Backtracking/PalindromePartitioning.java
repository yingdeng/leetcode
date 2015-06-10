public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        
        if (s.length() == 0 || s == null) {
            return null;
        }
        helper(s, 0, list, result);
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
    
    private void helper(String s, int index, ArrayList<String> list, ArrayList<ArrayList<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<String> (list));
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            String str = s.substring(index, i);
            if (!isPalindrome(str)) {
                continue;
            }
        list.add(str);
        helper(s, i, list, result);
        list.remove(list.size() - 1);
        }
    }
}