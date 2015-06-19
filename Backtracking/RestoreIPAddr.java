/*Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",
return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        
        if (s.length() < 3 || s.length() > 12) {
            return result;
        }
        helper(s, 0, tempList, result);
        return result;
    }
    
    public void helper(String s, int index, List<String> tempList, List<String> result) {
        if (tempList.size() == 4) {
            if (index != s.length()) {
                return;
            }
            
            StringBuffer sb = new StringBuffer();
            for(String subStr: list) {
                sb.append(subStr);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }
        
        for (int i = index; i <= index+3 && i < s.length(); i++) {
            String subStr = s.substring(index, i + 1);
            if (isValid(subStr)) {
                list.add(subStr);
                helper(s, i + 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public boolean isValid(String str) {
        
        int num = Integer.parseInt(str);
        if (str.charAt(0) == '0') {
            return str.equals("0");
        }
        if (num <= 255 && num > 0) {
            return true;
        }
        return false;
    }
}
