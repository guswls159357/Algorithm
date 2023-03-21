import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        return getPossibleCount(topping);
    }
    
    public int getPossibleCount(int[] toppings){
        
        Map<Integer, Integer> countMap1 = new HashMap();
        Map<Integer, Integer> countMap2 = new HashMap();
        
        int count = 0;
        int toppingLength = toppings.length;
        
        // 초기 상태 지정 - 모든 토핑을 한 사람이 가져가도록
        for(int i = 0 ; i < toppingLength ; i++){
            int topping = toppings[i];
            countMap2.put(topping, countMap2.getOrDefault(topping, 0) + 1);
        }
        
        // 칸막이를 이동해가며 다시 계산
        for(int divideIdx = 1 ; divideIdx < toppingLength; divideIdx++){
            int topping = toppings[divideIdx - 1];
            countMap1.put(topping, countMap1.getOrDefault(topping, 0) + 1);
            countMap2.put(topping, countMap2.get(topping) - 1);
            
            if(countMap2.get(topping) == 0){
                countMap2.remove(topping);
            }
            if(countMap1.keySet().size() == countMap2.keySet().size()){
                count++;
            }
        }
        
        return count;
    }
}