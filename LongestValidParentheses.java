public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int maxlen = 0;
        int start = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i <= s.length()-1; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            
            else {
                if (stack.isEmpty()) {
                    start = 0;
                }
                else {
                    int curPos = stack.pop();
                    if (stack.isEmpty()) {
                        int curlen = i - curPos + 1;
                        start += curlen;
                        curlen = start;
                        maxlen = Math.max(curlen, maxlen);
                    }
                    else {
                        int curlen = i - stack.peek();
                        maxlen = Math.max(curlen, maxlen);
                    }
                }
            }
        }
        return maxlen;
    }
}