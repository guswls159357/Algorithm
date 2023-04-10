import java.io.*;
import java.util.*;

public class Main {

    // N - 총 사람 수 , M - 부모 자식들 간의 관계의 갯수
    static int N, M;
    // x - 시작 , y - 끝
    static int x, y;
    static boolean[][] connected;
    static boolean[] visited;
    // 촌수를 계산할 수 없다면 -1
    static int answer = -1;

    public static void main(String[] args) throws IOException {

        initInput();
        dfs(x, 0);
        System.out.println(answer);
    }

    static void dfs(int start, int depth) {

        // 탈출 조건
        if (start == y) {
            answer = depth;
            return;
        }

        // 방문처리
        visited[start] = true;

        // 부모 자식 관계인 사람들만 재귀 호출
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && connected[start][i]) dfs(i, depth + 1);
        }

    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        connected = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            connected[p1][p2] = true;
            connected[p2][p1] = true;
        }

        br.close();
    }
}
