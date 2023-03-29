import java.util.*;

class Solution {
    
    int min = Integer.MAX_VALUE;
    int N, Y;
    // 최소 도달 횟수
    int[] arr = new int[1_000_001];
    
    public int solution(int x, int y, int n) {
        N = n;
        Y = y;
        bfs(x);
        
        if(x == y) return 0;
        
        return arr[y] != 0 ? arr[y] : -1;
    }
    
    public void bfs(int x){
        
        Queue<Integer> queue = new LinkedList();
        queue.add(x);
        
        while(!queue.isEmpty()){
            
            int curX = queue.poll();
            if(curX == Y) return;
            
            int[] nexts = new int[]{curX + N, curX * 2, curX * 3};
            
            for(int i = 0 ; i < 3 ; i++){
                int next = nexts[i];
                if(next <= Y){
                    if(arr[next] == 0 || arr[next] > arr[curX] + 1){
                        arr[next] = arr[curX] + 1;
                        queue.add(next);
                    }
                }
            }
        }
    }
}