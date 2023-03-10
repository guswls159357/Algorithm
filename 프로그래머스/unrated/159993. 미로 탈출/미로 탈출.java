import java.util.*;

class Solution {
    
    static class Point{
        int row;
        int col;
        int count;
        
        public Point(int row, int col, int count){
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
    
    static int R, C;
    static int startRow, startCol;
    static int leverRow, leverCol;
    static int exitRow, exitCol;
    static boolean[][] visited;
    static boolean[][] map;
    static int[] dirX = {1, -1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};
    
    public int solution(String[] maps) {
        
        initInput(maps);
        //printMap();
        int startToLever = getMinCountStartToLever();
        initVisited();
        int leverToEnd = getMinCountLeverToEnd();
        
        if(startToLever == 0 || leverToEnd == 0) return -1;
        else return startToLever + leverToEnd;
    }
    
    // 레버 지점에서 끝 지점까지 가는 최소 거리
    public int getMinCountLeverToEnd(){
        
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(leverRow, leverCol, 0));
        visited[leverRow][leverCol] = true;
        
        while(!queue.isEmpty()){
            Point p = queue.poll();
            int curRow = p.row;
            int curCol = p.col;
            int curCount = p.count;
            
            if(curRow == exitRow && curCol == exitCol) return curCount;
            
            for(int i = 0 ; i < 4 ; i++){
                int nextRow = curRow + dirX[i];
                int nextCol = curCol + dirY[i];
                
                if(isPossible(nextRow, nextCol)){
                    visited[nextRow][nextCol] = true;
                    queue.add(new Point(nextRow, nextCol, curCount + 1));
                }
            }
        }
        
        return 0;
    }
    
    // 시작 지점에서 레버 지점까지 가는 최소 거리
    public int getMinCountStartToLever(){
        
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startRow, startCol, 0));
        visited[startRow][startCol] = true;
        
        while(!queue.isEmpty()){
            Point p = queue.poll();
            int curRow = p.row;
            int curCol = p.col;
            int curCount = p.count;
            System.out.println(curRow + " " + curCol);
            
            if(curRow == leverRow && curCol == leverCol) return curCount;
            
            for(int i = 0 ; i < 4 ; i++){
                int nextRow = curRow + dirX[i];
                int nextCol = curCol + dirY[i];
                
                if(isPossible(nextRow, nextCol)){
                    visited[nextRow][nextCol] = true;
                    queue.add(new Point(nextRow, nextCol, curCount + 1));
                }
            }
        }
        
        return 0;
    }
    
    public boolean isPossible(int row, int col){
        
        if(row < 0 || R <= row || col < 0 || C <= col) return false;
        
        return !visited[row][col] && map[row][col];
    }
    
    public void initVisited(){
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                visited[i][j] = false;
            }
        }
    }
    
    public void initInput(String[] maps){
        
        R = maps.length;
        C = maps[0].length();
        
        map = new boolean[R][C];
        visited = new boolean[R][C];
        
        String tmp;
        for(int i = 0 ; i < R ; i++){
            tmp = maps[i];
            for(int j = 0 ; j < C ; j++){
                char c = tmp.charAt(j);
                if(c == 'S'){
                    startRow = i;
                    startCol = j;
                    map[i][j] = true;
                }else if(c == 'L'){
                    leverRow = i;
                    leverCol = j;
                    map[i][j] = true;
                }else if(c == 'E'){
                    exitRow = i;
                    exitCol = j;
                    map[i][j] = true;
                }else if(c == 'O'){
                    map[i][j] = true;
                }else{
                    map[i][j] = false;
                } 
            }
        }
    }
    
    public void printMap(){
        for(int i = 0 ; i < R ; i++){
            
            for(int j = 0 ; j < C ; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println(startRow + " " + startCol);
        System.out.println(leverRow + " " + leverCol);
        System.out.println(exitRow + " " + exitCol);
    }
}