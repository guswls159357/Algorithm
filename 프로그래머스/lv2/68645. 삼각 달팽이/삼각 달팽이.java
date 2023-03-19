class Solution {
    
    int[][] map;
    
    public int[] solution(int n) {
        map = draw(n);
        int[] result = new int[getSize(n)];
        
        int idx = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(map[i][j] != 0){
                    result[idx++] = map[i][j];
                }
            }
        }
        
        return result;
    }
    
    public int[][] draw(int n){
        
        map = new int[n][n];
        int[] dirX = {1, 0, -1};
        int[] dirY = {0, 1, -1};
        
        int curDir = 0;
        int num = 1;
        int curX = 0;
        int curY = 0;
        map[curX][curY] = num;
        
        while(true){
            
            // 현재 방향으로 진행하지 못할 때
            if(!isPossible(curX + dirX[curDir], curY + dirY[curDir], n)){
                curDir = curDir + 1 > 2 ? 0 : curDir + 1;
                // 방향을 꺾은 다음에도 진행하지 못할 때
                if(!isPossible(curX + dirX[curDir], curY + dirY[curDir], n)){
                    return map;
                }
            }
            
            curX += dirX[curDir];
            curY += dirY[curDir];
            map[curX][curY] = ++num;
        }
    }
    
    public boolean isPossible(int x, int y, int n){
        
        if(x < 0 || y < 0 || x >= n || y >= n) return false;
        return map[x][y] == 0;
    }
    
    public int getSize(int n){
        
        int sum = 0;
        for(int i = 1 ; i <= n ; i++){
            sum += i;
        }
        
        return sum;
    }
}