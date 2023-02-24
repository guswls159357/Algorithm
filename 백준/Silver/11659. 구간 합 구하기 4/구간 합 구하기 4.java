import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        // 숫자들의 갯수
        int N = Integer.parseInt(st.nextToken());
        // 구해야 하는 구간 합의 갯수
        int M = Integer.parseInt(st.nextToken());

        // 1 - 첫번째 숫자, 2 - 첫번째 + 두번째, 3 - 첫번째 + 두번째 + 세번째
        int[] sum = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int startIdx, endIdx;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            startIdx = Integer.parseInt(st.nextToken());
            endIdx = Integer.parseInt(st.nextToken());

            result.append(sum[endIdx] - sum[startIdx - 1]).append("\n");
        }

        System.out.println(result);

        br.close();
    }
}
