class Solution {
    
    char[][] map;
    boolean[][] checkMap;
    int rowSize;
    int colSize;
    
    // 오른쪽, 아래, 오른쪽아래
    int[] rowDir = {0, 1, 1};
    int[] colDir = {1, 0, 1};
    
    public int solution(int m, int n, String[] board) {
        rowSize = m;
        colSize = n;
        initMap(board);
        
        //printMap();
        
        while(refactorMap()){
            //printMap();
        }
        
        //printMap();
        
        return getResult();
    }
    
    void initMap(String[] board){
        
        map = new char[rowSize][colSize];
        checkMap = new boolean[rowSize][colSize];
        
        for(int i = 0 ; i < rowSize ; i++){
            String tmp = board[i];
            map[i] = tmp.toCharArray();
        }
    }
    
    void initCheckMap(){
        for(int i = 0 ; i < rowSize ; i++){
            checkMap[i] = new boolean[colSize];
        }
    }
    
    boolean refactorMap(){
        
        boolean isChanged = false;
        
        int maxRow = rowSize - 1;
        int maxCol = colSize - 1;
        for(int row = 0 ; row < maxRow ; row++){
            for(int col = 0 ; col < maxCol ; col++){
                char curVal = map[row][col];
                if(curVal != ' ' && checkDir(row, col)){
                    isChanged = true;
                    checkToCheckMap(row, col);
                }
            }
        }
        
        if(isChanged){
            removeFromMap();
            drop();
            initCheckMap();
        }
        
        return isChanged;
    }
    
    boolean checkDir(int row, int col){
        
        int nextRow = 0;
        int nextCol = 0;
        for(int i = 0 ; i < 3 ; i++){
            nextRow = row + rowDir[i];
            nextCol = col + colDir[i];
            if(map[row][col] != map[nextRow][nextCol]) return false;
        }
        
        return true;
    }
    
    void checkToCheckMap(int row, int col){
        checkMap[row][col] = true;
        int nextRow = 0;
        int nextCol = 0;
        for(int i = 0 ; i < 3 ; i++){
            nextRow = row + rowDir[i];
            nextCol = col + colDir[i];
            checkMap[nextRow][nextCol] = true;
        }
    }
    
    void removeFromMap(){
        
        for(int row = 0 ; row < rowSize ; row++){
            for(int col = 0 ; col < colSize ; col++){
                if(checkMap[row][col]) map[row][col] = ' ';
            }
        }
    }
    
    void drop(){
        for(int col = 0 ; col < colSize ; col++){
            dropCol(col);
        }
    }
    
    void dropCol(int col){
        
        for(int row = rowSize - 1 ; row > 0 ; row--){
            if(map[row][col] == ' '){
                int tmpRow = row - 1;
                while(tmpRow >= 0 && map[tmpRow][col] == ' '){
                    tmpRow--;
                }
                if(tmpRow >= 0){
                    map[row][col] = map[tmpRow][col];
                    map[tmpRow][col] = ' ';
                }
            }
        }
    }
    
    int getResult(){
        int count = 0;
        for(int i = 0 ; i < rowSize ; i++){
            for(int j = 0 ; j < colSize ; j++){
                if(map[i][j] == ' ') count++;
            }
        }
        
        return count;
    }
    
    void printMap(){
        for(int i = 0 ; i < rowSize ; i++){
            for(int j = 0 ; j < colSize ; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    void printCheckMap(){
        for(int i = 0 ; i < rowSize ; i++){
            for(int j = 0 ; j < colSize ; j++){
                System.out.print(checkMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}