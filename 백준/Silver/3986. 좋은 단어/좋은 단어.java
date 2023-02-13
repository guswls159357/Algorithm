import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;

        for (int i = 0; i < N; i++) {
            if (isGoodWord(br.readLine())) result++;
        }

        System.out.println(result);

        br.close();
    }

    static boolean isGoodWord(String s) {
        Stack<Character> stack = new Stack<>();

        char[] word = s.toCharArray();

        for (char c : word) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == 'A' && c == 'A') {
                    stack.pop();
                } else if (stack.peek() == 'B' && c == 'B') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();
    }
}