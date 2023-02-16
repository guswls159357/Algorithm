import java.io.*;
import java.util.*;

public class Main {

    static List[] arr;
    static int N;
    static int endIdx;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        endIdx = N - 1;
        arr = new List[N + 1];
        initArr();
        int num1, num2;

        for (int i = 0; i < endIdx; i++) {
            st = new StringTokenizer(br.readLine());
            num1 = Integer.parseInt(st.nextToken());
            num2 = Integer.parseInt(st.nextToken());

            arr[num1].add(num2);
            arr[num2].add(num1);
        }

        bfs();
    }

    static void bfs() {
        int[] result = new int[N + 1]; // 0 , 1 인덱스 제외

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        queue.add(1);
        visited[1] = true;
        int curNumber;
        int num;
        List<Integer> tmp;
        int length;

        while (!queue.isEmpty()) {
            curNumber = queue.poll();
            tmp = arr[curNumber];
            length = tmp.size();

            for (int i = 0; i < length; i++) {
                num = tmp.get(i);
                if(num == 0) break;
                if (!visited[num]) {
                    result[num] = curNumber;
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);

    }

    static void initArr(){

        for(int i = 1 ; i <= N ; i++){
            arr[i] = new ArrayList<>();
        }

    }

}
