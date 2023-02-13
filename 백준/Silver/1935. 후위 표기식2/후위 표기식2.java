import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] word = br.readLine().toCharArray();
        int[] charToInt = new int[26];

        for (int i = 0; i < N; i++) {
            charToInt[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        for (char c : word) {
            if ('A' <= c && c <= 'Z') {
                stack.push((double) charToInt[c - 'A']);
            } else if (c == '*') {
                stack.push(stack.pop() * stack.pop());
            } else if (c == '+') {
                stack.push(stack.pop() + stack.pop());
            } else if (c == '/') {
                double after = stack.pop();
                double before = stack.pop();
                stack.push(before / after);
            } else {
                double after = stack.pop();
                double before = stack.pop();
                stack.push(before - after);
            }
        }

        double result = stack.pop();

        System.out.println(String.format("%.2f", result));

        br.close();
    }


}
