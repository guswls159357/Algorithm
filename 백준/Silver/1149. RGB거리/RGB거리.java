import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] cost;
    static int[][] minCost;

    public static void main(String[] args) throws IOException {

        initInput();
        initMinCost();
        //print();
        System.out.println(Math.min(minCost[N][0], Math.min(minCost[N][1], minCost[N][2])));
    }

    static void initMinCost() {

        // 첫 번째 집을 칠할 때 최소값 설정
        for (int i = 0; i < 3; i++) {
            minCost[1][i] = cost[1][i];
        }

        // 두 번째 집부터 계산
        for (int homeIdx = 2; homeIdx <= N; homeIdx++) {
            // 각각 빨간색, 초록색, 파랑색으로 칠했을 때 최소값
            int beforeIdx = homeIdx - 1;
            minCost[homeIdx][0] = Math.min(minCost[beforeIdx][1], minCost[beforeIdx][2]) + cost[homeIdx][0];
            minCost[homeIdx][1] = Math.min(minCost[beforeIdx][0], minCost[beforeIdx][2]) + cost[homeIdx][1];
            minCost[homeIdx][2] = Math.min(minCost[beforeIdx][0], minCost[beforeIdx][1]) + cost[homeIdx][2];
        }

    }

    static void print(){
        for(int i = 1 ; i <= N ; i++){
            for(int j = 0 ; j < 3 ; j++){
                System.out.println(minCost[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        cost = new int[N + 1][3];
        minCost = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
    }

}
