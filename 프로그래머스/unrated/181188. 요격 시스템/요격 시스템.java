import java.util.*;

class Solution {
    
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (array1, array2) -> {
            if(array1[1] == array2[1]){
                return array1[0] - array2[0];
            }
            return array1[1] - array2[1];
        });
        
        int count = 1;
        int end = targets[0][1];
        
        for(int[] range : targets){
            if(end <= range[0]){
                end = range[1];
                count++;
            }
        }
        
        return count;
    }
}