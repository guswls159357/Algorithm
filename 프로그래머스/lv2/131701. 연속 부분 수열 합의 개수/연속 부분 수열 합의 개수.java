import java.util.*;

class Solution {
    
    Set<Integer> resultSet = new HashSet();
    int[] arr;
    int N;
    
    public int solution(int[] elements) {
        
        arr = elements;
        N = arr.length;
        initPartialSums();
        // for(int num : resultSet){
        //     System.out.println(num);
        // }
        
        return resultSet.size();
    }
    
    void initPartialSums(){
        
        int sum;
        
        for(int start = 0 ; start < N ; start++){
            sum = 0;
            for(int j = 0 ; j < N ;j++){
                sum += arr[(start + j) % N];
                resultSet.add(sum);
            }
        }
        
    }
}