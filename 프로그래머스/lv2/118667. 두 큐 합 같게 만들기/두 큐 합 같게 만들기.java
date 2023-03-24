import java.util.*;

class Solution {
    
    public int solution(int[] qqueue1, int[] qqueue2) {
        
        Queue<Integer> queue1 = new LinkedList();
        Queue<Integer> queue2 = new LinkedList();
        
        int length = qqueue1.length;
        int totalLength = length * 2;
        long sum1 = 0;
        long sum2 = 0;
        for(int i = 0 ; i < length ; i++){
            queue1.add(qqueue1[i]);
            queue2.add(qqueue2[i]);
            sum1 += qqueue1[i];
            sum2 += qqueue2[i];
        }
        
        // 이미 합이 같은 경우
        if(sum1 == sum2) return 0;
        // 합이 홀수이면 불가능
        else if((sum1 + sum2) % 2 == 1) return -1;
        
        // 최대 진행 가능한 횟수 - 각 큐에서 원소가 모두 사라질 때 -> 4 * length
        int end = length * 4;
        for(int i = 0 ; i < end ; i++){
            
            if(sum1 > sum2){
                int num = queue1.poll();
                queue2.add(num);
                sum1 -= num;
                sum2 += num;
            }else if(sum1 < sum2){
                int num = queue2.poll();
                queue1.add(num);
                sum1 += num;
                sum2 -= num;
            }else{
                return i;
            }   
        }
        return -1;
    }
}