import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static Deque<Integer> deque = new LinkedList<>();
    static int[] targets;

    public static void main(String[] args) throws IOException {

        int minCount = 0;
        initInput();

        for(int i = 0 ; i < M ; i++){
            minCount += removeAndGetCount(targets[i]);
        }

        System.out.println(minCount);
    }

    static int removeAndGetCount(int number) {

        int count = 0;

        while (!deque.isEmpty()) {
            if (deque.peekFirst() == number) break;
            else {
                count++;
                deque.addLast(deque.pollFirst());
            }
        }
        deque.pollFirst();

        return Math.min(count, deque.size() + 1 - count);
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 큐의 크기
        N = Integer.parseInt(st.nextToken());
        // 뽑으려고 하는 숫자의 수
        M = Integer.parseInt(st.nextToken());
        // 뽑으려는 숫자들
        targets = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        // 큐를 초기화한다.
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        br.close();
    }

}
