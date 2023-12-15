import java.util.*;

class Solution {
    public String solution(String s) {
        
        StringBuilder ans = new StringBuilder();
        
        char[] chars = s.toCharArray();
        
        char beforeChar = ' ';
        for(char c : chars){
            
            char tmp = c;
            
            // 현재 문자가 공백이라면 그대로 넣음
            if(c == ' '){
                
            }else if(beforeChar == ' '){
                // 현재 문자가 소문자라면 대문자로 변환한다
                if('a' <= c && c <= 'z'){
                    tmp = Character.toUpperCase(c);
                }
            }else{
                // 이전 문자가 공백이 아니라면
                // 현재 문자가 대문자라면 소문자로 변환한다
                if('A' <= c && c <= 'Z'){
                    tmp = Character.toLowerCase(c);
                }
            }
            
            // 결과 저장
            ans.append(tmp);
            // 이전 문자 초기화
            beforeChar = c;
            
        }
        
        return ans.toString();
    }
}