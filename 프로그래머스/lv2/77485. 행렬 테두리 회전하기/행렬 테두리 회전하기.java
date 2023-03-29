import java.util.*;

class Solution {
    
    int[] answer;
    int[][] map;
    int N, M;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int length = queries.length;
        answer = new int[length];
        N = rows;
        M = columns;
        initMap();
        for(int i = 0 ; i < length ; i++){
            rotate(i, queries[i]);
        }
        return answer;
    }
    
    public void rotate(int T, int[] query){
        
        int upRow = query[0];
        int downRow = query[2];
        int leftCol = query[1];
        int rightCol = query[3];
        int min = Integer.MAX_VALUE;
        
        int tmp = map[upRow][leftCol];
        // 왼쪽 회전
        for(int i = upRow ; i < downRow ; i++){
            min = Math.min(min, map[i][leftCol]);
            map[i][leftCol] = map[i+1][leftCol];
        }
        
        // 아래 회전
        for(int i = leftCol ; i < rightCol ; i++){
            min = Math.min(min, map[downRow][i]);
            map[downRow][i] = map[downRow][i+1];
        }
        
        // 오른쪽 회전
        for(int i = downRow ; upRow < i ; i--){
            min = Math.min(min, map[i][rightCol]);
            map[i][rightCol] = map[i-1][rightCol];
        }
        
        // 위쪽 회전
        int end = leftCol + 1;
        for(int i = rightCol ; end < i ; i--){
            min = Math.min(min, map[upRow][i]);
            map[upRow][i] = map[upRow][i-1];
        }
        
        // 마지막 값 대입
        min = Math.min(min, map[upRow][leftCol+1]);
        map[upRow][leftCol + 1] = tmp;
        
        answer[T] = min;
    }
    
    public void initMap(){
        
        map = new int[N+1][M+1];
        
        int num = 1;
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= M ; j++){
                map[i][j] = num++;
            }
        }
        
    }
    
}