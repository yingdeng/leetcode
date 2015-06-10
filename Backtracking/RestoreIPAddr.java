public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        
        if (s.length() < 3 || s.length() > 12) {
            return result;
        }
        helper(s, 0, list, result);
        return result;
    }
    
    public void helper(String s, int index, ArrayList<String> list, ArrayList<String> result) {
        if (list.size() == 4) {
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
        
        for (int i=index; i<=index+3 && i<s.length(); i++) {
            String subStr = s.substring(index, i+1);
            if (isValid(subStr)) {
                list.add(subStr);
                helper(s, i+1, list, result);
                list.remove(list.size()-1);
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