import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        MyDeque deque = new MyDeque();

        String operation;
        int value;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            operation = st.nextToken();

            switch (operation){
                case "push_front":
                    value = Integer.parseInt(st.nextToken());
                    deque.push_front(value);
                    break;
                case "push_back":
                    value = Integer.parseInt(st.nextToken());
                    deque.push_back(value);
                    break;
                case "pop_front":
                    sb.append(deque.pop_front()).append("\n");
                    break;
                case "pop_back":
                    sb.append(deque.pop_back()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty()).append("\n");
                    break;
                case "front":
                    sb.append(deque.front()).append("\n");
                    break;
                default:
                    sb.append(deque.back()).append("\n");
                    break;

            }
        }

        System.out.println(sb);

        br.close();
    }

    static class MyDeque {

        private int size;
        private int[] values;
        private int frontIdx;
        private int endIdx;

        public MyDeque() {
            this.size = 0;
            this.values = new int[20001]; // 0 ~ 20000 -> -10000 ~ 10000
            this.frontIdx = 10000;
            this.endIdx = 10001;
        }

        public void push_front(int value) {
            this.values[this.frontIdx--] = value;
            this.size++;
        }

        public void push_back(int value) {
            this.values[this.endIdx++] = value;
            this.size++;
        }

        public int pop_front() {
            if (this.size == 0) return -1;
            else {
                this.size--;
                return this.values[++this.frontIdx];
            }
        }

        public int pop_back() {
            if (this.size == 0) return -1;
            else {
                this.size--;
                return this.values[--this.endIdx];
            }
        }

        public int size() {
            return this.size;
        }

        public int isEmpty() {
            return size() == 0 ? 1 : 0;
        }

        public int front() {
            if (this.size == 0) return -1;
            return values[frontIdx + 1];
        }

        public int back() {
            if (this.size == 0) return -1;
            return values[endIdx - 1];
        }
    }

}
