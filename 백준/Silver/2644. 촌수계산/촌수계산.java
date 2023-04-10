import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int num1, num2;
    static int answer = -1;
    static boolean[][] connected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        initInput();
        dfs(num1, 0);
        System.out.println(answer);
    }

    static void dfs(int start, int depth) {

        visited[start] = true;
        //System.out.println(start);

        if (start == num2) {
            answer = depth;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (i != start && !visited[i] && connected[start][i]) {
                dfs(i, depth + 1);
            }
        }
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        connected = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        num1 = Integer.parseInt(st.nextToken());
        num2 = Integer.parseInt(st.nextToken());

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
