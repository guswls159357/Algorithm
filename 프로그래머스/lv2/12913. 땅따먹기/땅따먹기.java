import java.util.*;

class Solution {
    
    int[][] land;
    int[][] max;
    int rowSize = 0;
    
    int solution(int[][] lands) {
        
        land = lands;
        initMax();

        return Arrays.stream(max[rowSize - 1]).max().getAsInt();
    }
    
    void initMax(){
        
        rowSize = land.length;
        max = new int[rowSize][4];
        
        // 첫번째줄 초기화
        for(int col = 0 ; col < 4 ; col++){
            max[0][col] = land[0][col];
        }
        
        for(int row = 1 ; row < rowSize ; row++){
            for(int col = 0 ; col < 4 ; col++){
                int maxVal = 0;
                for(int beforeCol = 0 ; beforeCol < 4 ; beforeCol++){
                    if(col != beforeCol && maxVal < max[row - 1][beforeCol]){
                        maxVal = max[row - 1][beforeCol];
                    }
                }
                max[row][col] = maxVal + land[row][col];
            }
        }
    }
}