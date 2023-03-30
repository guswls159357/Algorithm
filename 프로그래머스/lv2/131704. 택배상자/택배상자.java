import java.util.*;

class Solution {
    
    Stack<Integer> tmpConveyor = new Stack();
    Stack<Integer> conveyor = new Stack();
    int N;
    int[] order;
    
    public int solution(int[] orderr) {
        order = orderr;
        N = order.length;
        initConveyor();
        
        return getPossibleCnt();
    }
    
    public int getPossibleCnt(){
        
        int cnt = 0;
        
        for(int i = 0 ; i < N ; i++){
            int target = order[i];
            
            if(conveyor.isEmpty() || conveyor.peek() > target){
                if(tmpConveyor.isEmpty() || tmpConveyor.peek() != target){
                    return cnt;
                } else{
                    cnt++;
                    tmpConveyor.pop();
                }
            }else if(conveyor.peek() < target){
                while(conveyor.peek() != target){
                    tmpConveyor.push(conveyor.pop());
                }
                conveyor.pop();
                cnt++;
            }else if(conveyor.peek() == target){
                conveyor.pop();
                cnt++;
            }
        }
        
        return cnt;
        
    }
    
    public void initConveyor(){
        
        for(int i = N ; 1 <= i ; i--){
            conveyor.push(i);
        }
        
    }
}