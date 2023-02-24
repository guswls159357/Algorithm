import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        // 1차원 배열의 인덱스 범위 = 1 ~ N X N
        int N = Integer.parseInt(st.nextToken());
        int endIdx = N + 1;
        // 구해야 할 구간 합의 갯수
        int Q = Integer.parseInt(st.nextToken());

        int[][] arr = new int[endIdx][endIdx];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sum = new int[endIdx][endIdx];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i-1][j-1] + arr[i][j];
            }
        }

        int startRow, startCol, endRow, endCol;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            startRow = Integer.parseInt(st.nextToken());
            startCol = Integer.parseInt(st.nextToken());
            endRow = Integer.parseInt(st.nextToken());
            endCol = Integer.parseInt(st.nextToken());

            result.append(sum[endRow][endCol]
                            - sum[startRow - 1][endCol]
                            - sum[endRow][startCol - 1]
                            + sum[startRow - 1][startCol - 1])
                    .append("\n");
        }

        System.out.println(result);

        br.close();
    }
}
