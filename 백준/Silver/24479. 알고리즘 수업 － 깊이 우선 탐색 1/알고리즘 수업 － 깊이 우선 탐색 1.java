import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    // 정점의 수, 간선의 수, 시작 정점
    static int N, M, R;
    static Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    static int[] result;
    static boolean[] visited;
    static int size = 0;

    public static void main(String[] args) throws IOException {

        initInput();
        dfs(R);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start) {

        result[start] = ++size;
        visited[start] = true;
        if (!map.containsKey(start)) {
            return;
        }
        PriorityQueue<Integer> queue = map.get(start);

        while (!queue.isEmpty()) {
            int next = queue.poll();
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        result = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            putToMap(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        br.close();
    }

    static void putToMap(int num1, int num2) {

        if (map.containsKey(num1)) map.get(num1).add(num2);
        else {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            priorityQueue.add(num2);
            map.put(num1, priorityQueue);
        }

        if (map.containsKey(num2)) map.get(num2).add(num1);
        else {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            priorityQueue.add(num1);
            map.put(num2, priorityQueue);
        }
    }

}
