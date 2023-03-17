import java.util.*;

class Solution {
    
    int zeroCnt = 0;
    int oneCnt = 0;
    int[][] map;
    
    public int[] solution(int[][] arr) {
        
        map = arr;
        
        checkBox(arr.length, 0, 0);
        
        int[] answer = new int[2];
        answer[0] = zeroCnt;
        answer[1] = oneCnt;
        return answer;
    }
    
    public void checkBox(int n, int startRow, int startCol){
        
        int check = checkAll(n, startRow, startCol);
        if(check == 0) {
            zeroCnt++;
            return;
        }
        else if(check == 1) {
            oneCnt++;
            return;
        }
        
        int nextSize = n / 2;
        
        checkBox(nextSize, startRow, startCol);
        checkBox(nextSize, startRow + nextSize, startCol);
        checkBox(nextSize, startRow, startCol + nextSize);
        checkBox(nextSize, startRow + nextSize, startCol + nextSize);
    }
    
    // 모두 0이면 0, 모두 1이면 1, 섞여있다면 -1
    public int checkAll(int n, int startRow, int startCol){
        
        int one = 0;
        int zero = 0;
        int endRow = startRow + n;
        int endCol = startCol + n;
        
        for(int i = startRow ; i < endRow ; i++){
            for(int j = startCol ; j < endCol ; j++){
                if(map[i][j] == 0){
                    if(one != 0) return -1;
                    zero++;
                }else{
                    if(zero != 0) return -1;
                    one++;
                }
            }
        }
        
        return zero == 0 ? 1 : 0;
    }
}