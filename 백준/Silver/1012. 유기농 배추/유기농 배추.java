import java.io.*;
import java.util.*;

public class Main {

    static int T, N, M, K;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dirRow = {1, -1, 0, 0};
    static int[] dirCol = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        printResult();
    }

    static int getCount(){

        int count = 0;

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] && !visited[i][j]){
                    visited[i][j] = true;
                    dfs(i, j);
                    count++;
                }
            }
        }

        return count;
    }

    static void dfs(int row, int col){

        for(int i = 0 ; i < 4 ; i++){
            int nextRow = row + dirRow[i];
            int nextCol = col + dirCol[i];

            if(isPossible(nextRow, nextCol)){
                visited[nextRow][nextCol] = true;
                dfs(nextRow, nextCol);
            }
        }

    }

    static boolean isPossible(int row, int col){
        if(row < 0 || col < 0 || N <= row || M <= col) return false;
        return map[row][col] && !visited[row][col];
    }

    static void printResult() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new boolean[N][M];
            visited = new boolean[N][M];

            for(int j = 0 ; j < K ; j++){
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());
                map[row][col] = true;
            }

            sb.append(getCount()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
