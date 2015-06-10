public class Solution {
    public String simplifyPath(String path) {
        if (path.length() == 0 || path == null) {
            return null;
        }
        
        Stack<String> stack = new Stack<>();
        String[] s = path.split("/");
        
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals(".") || s[i].length()==0) {
                continue;
            }
            else if (s[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(s[i]);
            }
        }
        
        StringBuilder res = new StringBuilder();
        Stack<String> temp = new Stack<>();
        
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        
        while (!temp.isEmpty()) {
            res.append("/" + temp.pop());
        }
        
        if (res.length() == 0) {
            res.append("/"); 
        }
        
        return res.toString();
    }
}