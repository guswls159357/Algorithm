import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int N, M;
    static int[] dirX = {1, -1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};
    static boolean[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        initInput();
        System.out.println(bfs());

    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0 ; j < M ; j++){
                map[i][j] = (s.charAt(j) == '1');
            }
        }

        br.close();
    }

    static int bfs(){

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Point point = queue.poll();
            int curX = point.x;
            int curY = point.y;

            if(curX == N - 1 && curY == M - 1) return point.count;
            for(int i = 0 ; i < 4 ; i++){
                int nextX = curX + dirX[i];
                int nextY = curY + dirY[i];

                if(isPossible(nextX, nextY)){
                    visited[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY, point.count + 1));
                }
            }
        }

        return -1;
    }

    static boolean isPossible(int x, int y) {

        if (x < 0 || N <= x || y < 0 || M <= y) return false;
        return map[x][y] && !visited[x][y];
    }

}

