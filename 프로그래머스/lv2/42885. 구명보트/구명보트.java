import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        
        // 가장 몸무게가 많이 나가는 사람과 가장 적게 나가는 사람을 비교한다.
        int start = 0;
        int end = people.length - 1;
        int count = 0;
        
        while(start < end){
            if(people[start] + people[end] <= limit){
                start++;
            }
            end--;
            count++;
        }
        
        if(start == end) return count + 1;
        return count;
    }
}