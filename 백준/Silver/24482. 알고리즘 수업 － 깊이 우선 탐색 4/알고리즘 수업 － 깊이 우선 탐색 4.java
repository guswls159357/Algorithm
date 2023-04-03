import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R;
    static PriorityQueue<Integer>[] adjQueue;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {

        initInput();
        visited[R] = true;
        dfs(R, 0);
        printAnswer();
    }

    static void printAnswer() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        adjQueue = new PriorityQueue[N + 1];
        visited = new boolean[N + 1];
        result = new int[N + 1];
        Arrays.fill(result, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            addToAdjList(n1, n2);
        }
        br.close();
    }

    private static void dfs(int start, int depth) {

        result[start] = depth;
        if(adjQueue[start] == null) return;

        PriorityQueue<Integer> adjNumbers = adjQueue[start];
        while (!adjNumbers.isEmpty()) {
            int num = adjNumbers.poll();
            if (!visited[num]) {
                visited[num] = true;
                dfs(num, depth + 1);
            }
        }
    }

    private static void addToAdjList(int n1, int n2) {

        if (adjQueue[n1] == null) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            queue.add(n2);
            adjQueue[n1] = queue;
        } else {
            adjQueue[n1].add(n2);
        }

        if (adjQueue[n2] == null) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            queue.add(n1);
            adjQueue[n2] = queue;
        } else {
            adjQueue[n2].add(n1);
        }
    }
}

