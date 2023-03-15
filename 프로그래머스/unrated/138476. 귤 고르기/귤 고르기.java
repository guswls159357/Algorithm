import java.util.*;

class Solution {
    
    public int solution(int k, int[] tangerine) {
        
        Map<Integer, Integer> countMap = new HashMap();
        
        int length = tangerine.length;
        for(int i = 0 ; i < length ; i++){
            int key = tangerine[i];
            if(countMap.containsKey(key)){
                countMap.put(key, countMap.get(key) + 1);
            }else{
                countMap.put(key, 1);
            }
        }
        
        List<Integer> counts = new ArrayList(countMap.values());
        Collections.sort(counts, Collections.reverseOrder());
        
        int result = 0;
        for(int count : counts){
            if(count >= k){
                result++;
                break;
            }else{
                result++;
                k -= count;
            }
        }
        
        return result;
    }
}