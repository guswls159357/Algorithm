import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int N, M;
    static boolean[][] visited;
    static List<Point> zeros = new ArrayList<>();
    static int zeroSize;
    static int[][] map;
    static int[] dirRow = {1, -1, 0, 0};
    static int[] dirCol = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        initInput();

        System.out.println(getMaxSum());
    }

    static int getMaxSum(){

        int maxSum = 0;

        // 3개의 빈 칸을 구한다.
        int size = zeros.size();
        Point p1, p2, p3;
        for(int i = 0 ; i < size - 2 ; i++){
            p1 = zeros.get(i);
            map[p1.row][p1.col] = 1;
            for(int j = i + 1 ; j < size - 1 ; j++){
                p2 = zeros.get(j);
                map[p2.row][p2.col] = 1;
                for(int k = j + 1 ; k < size ; k++){
                    p3 = zeros.get(k);
                    map[p3.row][p3.col] = 1;
                    int sum = zeroSize - getSum();
                    if(sum > maxSum) maxSum = sum;
                    map[p3.row][p3.col] = 0;
                }
                map[p2.row][p2.col] = 0;
            }
            map[p1.row][p1.col] = 0;
        }

        return maxSum;
    }

    // 바이러스로 칠해진 영역의 갯수 리턴
    static int getSum(){

        int totalVirusCnt = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] == 2) {
                    totalVirusCnt += bfs(i, j);
                }
            }
        }
        initVisited();
        return totalVirusCnt;
    }

    // 칠해진 바이러스의 갯수를 리턴한다.
    static int bfs(int row, int col) {

        int cnt = 0;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row, col));
        visited[row][col] = true;

        while(!queue.isEmpty()){
            Point curP = queue.poll();
            int curRow = curP.row;
            int curCol = curP.col;

            for(int i = 0; i < 4 ; i++){
                int nextRow = curRow + dirRow[i];
                int nextCol = curCol + dirCol[i];
                if(isPossible(nextRow, nextCol)){
                    cnt++;
                    visited[nextRow][nextCol] = true;
                    queue.add(new Point(nextRow, nextCol));
                }
            }
        }

        return cnt;
    }

    static boolean isPossible(int row, int col){

        if(row < 0 || col < 0 || N <= row || M <= col) return false;
        return !visited[row][col] && map[row][col] == 0;
    }

    static void initVisited() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp;
            for (int j = 0; j < M; j++) {
                tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if(tmp == 0) zeros.add(new Point(i, j));
            }
        }

        zeroSize = zeros.size() - 3;

        br.close();
    }

}

