import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Character> operations = new Stack<>();
        for (int i = 0; i < N; i++) {
            operations.push(st.nextToken().charAt(0));
        }

        getOriginCards(operations, N).forEach(num -> sb.append(num).append(" "));

        System.out.println(sb);

        br.close();
    }

    static Deque<Integer> getOriginCards(Stack<Character> operations, int N){

        char operation;
        Deque<Integer> originalDeque = new LinkedList<>();
        Queue<Integer> changedQueue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            changedQueue.add(i);
        }

        while(!operations.isEmpty()){
            operation = operations.pop();

            switch (operation){
                case '1':
                    originalDeque.addFirst(changedQueue.poll());
                    break;
                case '2':
                    int temp = originalDeque.pollFirst();
                    originalDeque.addFirst(changedQueue.poll());
                    originalDeque.addFirst(temp);
                    break;
                case '3':
                    originalDeque.addLast(changedQueue.poll());
                    break;
                default: break;
            }
        }

        return originalDeque;
    }

}
