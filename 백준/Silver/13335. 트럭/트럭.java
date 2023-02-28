import java.io.*;
import java.util.*;

public class Main {

    static class Truck {
        int startTime;
        int weight;

        public Truck(int startTime, int weight) {
            this.startTime = startTime;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 트럭의 갯수
        int N = Integer.parseInt(st.nextToken());
        // 다리위의 최대 트럭 갯수 == 다리의 길이
        int W = Integer.parseInt(st.nextToken());
        // 다리의 최대 하중
        int L = Integer.parseInt(st.nextToken());

        int[] weights = new int[N];
        Queue<Truck> queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        int curWeight = 0;
        int curSize = 0;
        int time = 0;
        int curTruckIdx = 0;

        while (true) {
            time++;

            if (!queue.isEmpty()) {
                // 가장 최근에 들어온 트럭이 다리를 지나쳤을 때
                if (time - queue.peek().startTime == W) {
                    curSize--;
                    curWeight -= queue.poll().weight;
                }

                // 새로운 트럭이 들어올 수 있을 때 트럭을 넣는다.
                if(curTruckIdx < N && curSize < W && weights[curTruckIdx] + curWeight <= L){
                    curSize++;
                    curWeight += weights[curTruckIdx];
                    queue.add(new Truck(time, weights[curTruckIdx]));
                    curTruckIdx++;
                }
            } else {
                curSize++;
                curWeight += weights[curTruckIdx];
                queue.add(new Truck(time, weights[curTruckIdx]));
                curTruckIdx++;
            }

            if(curTruckIdx >= N && curSize == 0) break;
        }

        System.out.println(time);
    }
}
