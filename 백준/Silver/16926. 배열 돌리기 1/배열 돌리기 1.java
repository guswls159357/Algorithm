import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        initInput();

        int maxDepth = Math.min(N / 2, M / 2) - 1;
        for (int i = 0; i < R; i++) {
            for(int depth = 0 ; depth <= maxDepth ; depth++){
                rotate(depth);
            }
        }

        printArr();
    }

    // depth 는 0 부터 시작
    static void rotate(int depth) {

        int leftCol = depth;
        int upRow = depth;
        int rightCol = M - depth - 1;
        int downRow = N - depth - 1;
        int leftUp = map[upRow][leftCol];

        // 위쪽
        for (int col = leftCol; col < rightCol; col++) {
            map[upRow][col] = map[upRow][col + 1];
        }

        //printArr();

        // 오른쪽
        for (int row = upRow; row < downRow; row++) {
            map[row][rightCol] = map[row + 1][rightCol];
        }

        //printArr();

        // 아래쪽
        for (int col = rightCol; leftCol < col; col--) {
            map[downRow][col] = map[downRow][col - 1];
        }

        //printArr();

        // 왼쪽
        int endRow = upRow + 1;
        for (int row = downRow; endRow < row; row--) {
            map[row][leftCol] = map[row - 1][leftCol];
        }

        // 마지막 부분 저장
        map[upRow + 1][leftCol] = leftUp;
    }

    static void printArr() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
    }

}
