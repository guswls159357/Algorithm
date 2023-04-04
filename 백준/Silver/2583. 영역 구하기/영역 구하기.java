import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K, count, area;
    static PriorityQueue<Integer> areaQueue = new PriorityQueue<>();
    static boolean[][] visited;
    static int[] dirRow = {1, -1, 0, 0};
    static int[] dirCol = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        initInput();

        // 각 원소를 돌며 dfs
        for(int i = 0 ; i < M ; i++){
            for(int j = 0 ; j < N ; j++){
                if(!visited[i][j]) {
                    area = 0;
                    dfs(i, j);
                    areaQueue.add(area);
                    count++;
                }
            }
        }

        printAnswer();
    }

    static void printAnswer(){
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");

        while(!areaQueue.isEmpty()){
            sb.append(areaQueue.poll()).append(" ");
        }

        System.out.println(sb);
    }


    static void dfs(int row, int col) {

        visited[row][col] = true;
        area++;

        for(int i = 0 ; i < 4 ; i++){
            int nextRow = row + dirRow[i];
            int nextCol = col + dirCol[i];

            if(checkRange(nextRow, nextCol) && !visited[nextRow][nextCol]) {
                dfs(nextRow, nextCol);
            }
        }
    }

    static boolean checkRange(int row, int col){

        return (row >= 0 && row < M && col >= 0 && col < N);
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            drawRec(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        br.close();
    }

    static void drawRec(int r1, int c1, int r2, int c2) {

        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                visited[i][j] = true;
            }
        }
    }
}
