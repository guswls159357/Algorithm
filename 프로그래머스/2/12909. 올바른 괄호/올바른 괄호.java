import java.util.*;

class Solution {
    boolean solution(String s) {

        Stack<Character> stack = new Stack();
        
        int length = s.length();
        
        for(int i = 0 ; i < length ; i++){
            
            char c = s.charAt(i);
            
            // ( 이면 넣는다
            if(c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty() || stack.peek() != '(') return false;
                stack.pop();
            }
            
        }
        
        if(stack.isEmpty()) return true;
        return false;
    }
}