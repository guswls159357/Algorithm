import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int index;
        int value;

        public Point(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] result = new int[N];
        Arrays.fill(result, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Point> stack = new Stack<>();
        Point tmp;
        int curValue;

        for (int i = 0; i < N; i++) {
            curValue = arr[i];
            if (stack.isEmpty()) stack.push(new Point(i, curValue));

            while(!stack.isEmpty() && stack.peek().value < curValue){
                result[stack.pop().index] = curValue;
            }

            stack.push(new Point(i, curValue));
        }

        for(int ans : result){
            sb.append(ans).append(" ");
        }

        System.out.println(sb);

        br.close();
    }

}
