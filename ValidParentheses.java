public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
			return false;
		}
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			
			if(c == '(' || c == '{' || c == '['){
				stack.push(c);
			}
			else if(c == ')'){
			    if(stack.size() == 0 || stack.peek() != '(')
			    	return false;
			    else
			    	stack.pop();
			}
			else if(c == '}'){
				if(stack.size() == 0 || stack.peek() != '{')
					return false;
				else
					stack.pop();
			}
			else if(c == ']'){
				if(stack.size() == 0 || stack.peek() != '[')
					return false;
				else
					stack.pop();
			}
		}
        if(stack.size() > 0)
           return false;

		return true;
		
    }
}