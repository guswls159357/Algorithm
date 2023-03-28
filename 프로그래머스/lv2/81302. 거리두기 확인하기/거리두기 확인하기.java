import java.util.*;

class Solution {
    
    static class Point{
        int x;
        int y;
        int dis;
        
        public Point(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    
    String[][] places;
    char[][] map = new char[5][5];
    boolean[][] visited = new boolean[5][5];
    int[] dirX = {1, -1, 0, 0};
    int[] dirY = {0, 0, 1, -1};
    int[] result = new int[5];
    
    public int[] solution(String[][] placess) {
        
        places = placess;
        
        for(int i = 0 ; i < 5 ; i++){
            setAnswer(i);
        }
        return result;
    }
    
    public void setAnswer(int T){
        
        initMap(places[T]);
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                if(map[i][j] == 'P' && !bfs(i, j)){
                    result[T] = 0;
                    return;
                }
            }
        }
        result[T] = 1;
    }
    
    public boolean bfs(int x, int y){
        
        initVisited();
        
        Queue<Point> queue = new LinkedList();
        queue.add(new Point(x, y, 0));
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            
            Point curP = queue.poll();
            int curX = curP.x;
            int curY = curP.y;
            int curDis = curP.dis;
            
            if(map[curX][curY] == 'P' && 0 < curDis && curDis <= 2) {
                return false;
            }
            
            for(int i = 0 ; i < 4 ; i++){
                int nextX = curX + dirX[i];
                int nextY = curY + dirY[i];
                
                if(isPossible(nextX, nextY)){
                    visited[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY, curDis + 1));
                }
            }
        }
        
        return true;
    }
    
    public boolean isPossible(int x, int y){
        if(x < 0 || 5 <= x || y < 0 || 5 <= y) return false;
        return !visited[x][y] && map[x][y] != 'X';
    }
    
    public void initMap(String[] place){
        for(int i = 0 ; i < 5 ; i++){
            String s = place[i];
            for(int j = 0 ; j < 5 ; j++){
                map[i][j] = s.charAt(j);
            }
        }
    }
    
    public void initVisited(){
        
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                visited[i][j] = false;
            }
        }
    }
}