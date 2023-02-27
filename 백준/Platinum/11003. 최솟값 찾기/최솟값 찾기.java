import java.io.*;
import java.util.*;

public class Main {

    static class Element implements Comparable<Element> {
        int index;
        int value;

        public Element(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Element o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int startIdx = -L;

        Deque<Element> deque = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        int tmpVal;
        for (int i = 0; i < N; i++) {

            tmpVal = Integer.parseInt(st.nextToken());

            //deque 에 제자리에 추가
            while(!deque.isEmpty() && deque.peekLast().value > tmpVal){
                deque.pollLast();
            }
            deque.addLast(new Element(i, tmpVal));

            if(deque.peekFirst().index <= startIdx++){
                deque.pollFirst();
            }

            //현재 최소값
            sb.append(deque.peekFirst().value).append(" ");
        }

        System.out.println(sb);

        br.close();
    }

}
