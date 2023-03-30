import java.util.*;

class Solution {
    
    static class Point{
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    int N, M;
    int[][] map;
    boolean[][] visited;
    List<Integer> answer = new ArrayList();
    
    int[] dirX = {1, -1, 0, 0};
    int[] dirY = {0, 0, 1, -1};
    
    public int[] solution(String[] maps) {
        
        init(maps);
        
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(!visited[i][j] && map[i][j] != 0){
                    answer.add(bfs(i, j));
                }
            }
        }
        
        if(answer.size() == 0) return new int[]{-1};
        Collections.sort(answer);
        int length = answer.size();
        int[] arr = new int[length];
        
        for(int i = 0 ; i < length ; i++){
            arr[i] = answer.get(i);
        }
        
        return arr;
    }
    
    public int bfs(int x, int y){
        
        Queue<Point> queue = new LinkedList();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        
        int sum = map[x][y];
        while(!queue.isEmpty()){
            Point p = queue.poll();
            int curX = p.x;
            int curY = p.y;
            
            for(int i = 0 ; i < 4 ; i++){
                int nextX = curX + dirX[i];
                int nextY = curY + dirY[i];
                
                if(isPossible(nextX, nextY)){
                    visited[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY));
                    sum += map[nextX][nextY];
                }
            }
        }
        
        return sum;
    }
    
    public boolean isPossible(int x, int y){
        if(x < 0 || N <= x || y < 0 || M <= y) return false;
        
        return map[x][y] != 0 && !visited[x][y];
    }
    
    public void init(String[] maps){
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        map = new int[N][M];
        
        for(int i = 0 ; i < N ; i++){
            String s = maps[i];
            for(int j = 0 ; j < M ; j++){
                char c = s.charAt(j);
                if(c == 'X') map[i][j] = 0;
                else map[i][j] = c - '0';
            }
        }
    }
}