import java.util.*;

class Solution {
    
    static int totalCnt = 0;
    static int zeroCnt = 0;
    
    public int[] solution(String s) {
        
        while(!s.equals("1")) {
            String removedZero = removeZero(s);
            s = transform(removedZero.length());
        }
        
        return new int[]{totalCnt, zeroCnt};
    }
    
    public String removeZero(String number){
        
        StringBuilder sb = new StringBuilder();
        
        int size = number.length();
        for(int i = 0 ; i < size ; i++){
            if(number.charAt(i) == '1') sb.append('1');
            else zeroCnt += 1;
        }
        
        return sb.toString();
    }
    
    public String transform(int number){
        
        totalCnt++;
        
        StringBuilder sb = new StringBuilder();
        
        while(number != 0){
            
            sb.append(number % 2);
            
            number /= 2;
        }
        
        String result = sb.reverse().toString();
        
        return sb.reverse().toString();
    }
    
    
}