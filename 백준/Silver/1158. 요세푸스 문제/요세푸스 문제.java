import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String [] input = br.readLine().split(" ");


        int N = Integer.parseInt(input[0]);

        int K = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();

        sb.append("<");

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int count = 0;

        while (!queue.isEmpty()) {
            count++;
            if (count % K == 0) {
                if (queue.size() == 1) sb.append(queue.remove() + ">");
                else {
                    sb.append(queue.remove() + ", ");
                }
            } else {
                queue.add(queue.remove());
            }
        }
        System.out.println(sb);
    }
}
