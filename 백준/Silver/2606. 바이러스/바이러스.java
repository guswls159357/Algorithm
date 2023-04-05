import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N; // 컴퓨터의 수
    static int M; // 간선 갯수
    static int count; // 1 번 컴퓨터로 감염되는 컴퓨터의 수
    static boolean[][] connectedMap; // 연결 상태 배열
    static boolean[] visited; // 방문 배열

    public static void main(String[] args) throws IOException {

        initInput();
        dfs(1);
        System.out.println(count - 1);
    }

    static void dfs(int start) {

        visited[start] = true;
        count++;

        for (int i = 2; i <= N; i++) {
            if (connectedMap[start][i] && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        connectedMap = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());

            connectedMap[com1][com2] = true;
            connectedMap[com2][com1] = true;
        }

        br.close();
    }
}
