import java.util.*;
import java.util.stream.*;

class Solution {
    
    public String solution(int[] numbers) {
                
        StringBuilder result = new StringBuilder();
    
        List<String> numberList = 
            Arrays.stream(numbers).mapToObj(String::valueOf)
            .collect(Collectors.toList());
        
         Comparator<String> comp = (s1, s2) -> {
            return (s2+s1).compareTo(s1+s2);
         };
        
        Collections.sort(numberList, comp);
        
        boolean isAllZero = true;
        for(String num : numberList){
            if(num.equals("0") && isAllZero){
                continue;
            }
            
            isAllZero = false;
            result.append(num);
        }
        
        if(result.length() == 0) return "0";
        
        return result.toString();
    }
}