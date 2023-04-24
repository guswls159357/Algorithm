import java.util.*;

class Solution {
    public String solution(String p) {
        
        return recur(p);
    }
    
    String recur(String w){
        
        if(w.equals("")) return "";
        
        String[] result = split(w);
        String u = result[0];
        String v = result[1];
        
        if(is_올바른(u)){
            return u + recur(v);
        }else{
            StringBuilder sb1 = new StringBuilder();
            sb1.append("(");
            sb1.append(recur(v));
            sb1.append(")");
            StringBuilder sb2 = new StringBuilder(u);
            sb2.deleteCharAt(0);
            sb2.deleteCharAt(sb2.length() - 1);
            sb1.append(reverse(sb2.toString()));
            return sb1.toString();
        }
        
    }
    
    String reverse(String s){
                
        char[] chars = s.toCharArray(); 
        
        for(int i = 0 ; i < chars.length ; i++){
            if(chars[i] == '(') chars[i] = ')';
            else chars[i] = '(';
        }
                
        return String.valueOf(chars);
    }
    
    String[] split(String w){
        
        int count1 = 0;
        int count2 = 0;
        int length = w.length();
        String[] result = new String[]{"", ""};
        
        for(int i = 0 ; i < length ; i++){
            if(w.charAt(i) == '(') count1++;
            else count2++;
            
            if(count1 == count2){
                result[0] = w.substring(0, i + 1);
                if(length >= i + 1) result[1] = w.substring(i + 1);
                return result;
            }
        }
        
        return result;
    }
    
    
    boolean is_균형(String s){
        
        int length = s.length();
        int count1 = 0;
        int count2 = 0;
        
        for(int i = 0 ; i < length ; i++){
            if(s.charAt(i) == '(') count1++;
            else count2++;
        }
        
        return count1 == count2;
    }
    
    boolean is_올바른(String s){
        
        Stack<Character> stack = new Stack();
        int length = s.length();
        
        for(int i = 0 ; i < length ; i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty() || stack.peek() == ')') return false;
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}


