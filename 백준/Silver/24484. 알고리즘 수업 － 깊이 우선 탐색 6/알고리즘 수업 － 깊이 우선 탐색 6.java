import java.io.*;
import java.util.*;

public class Main {

    // 정점의 수, 간선의 수, 시작 정점
    static int N, M, R;
    static long result;
    static int order = 0;
    static Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        initInput();
        dfs(R, 0);
        System.out.println(result);
    }

    static void dfs(int start, int depth) {

        visited[start] = true;
        order++;
        result += (long) depth * order;

        if(!map.containsKey(start)) return;

        PriorityQueue<Integer> queue = map.get(start);
        while (!queue.isEmpty()) {
            int next = queue.poll();
            if(!visited[next]) dfs(next, depth + 1);
        }
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            putToMap(num1, num2);
            putToMap(num2, num1);
        }

        br.close();
    }

    static void putToMap(int num1, int num2) {

        if (!map.containsKey(num1)) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            priorityQueue.add(num2);
            map.put(num1, priorityQueue);
        } else {
            map.get(num1).add(num2);
        }

    }
}
