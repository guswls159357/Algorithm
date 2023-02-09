import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int N;
    public static int M;

    public static int answer = 0;

    public static boolean notPossible[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int size = N + 1;
        notPossible = new boolean[size][size];

        int x;
        int y;

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            notPossible[x][y] = true;
            notPossible[y][x] = true;
        }

        for(int i = 1 ; i < N - 1 ; i++){
            for(int j = i + 1 ; j < N ; j++){
                for(int k = j + 1 ; k <= N ; k++){
                    if(notPossible[i][j] || notPossible[i][k] || notPossible[j][k]){

                    }else answer++;
                }
            }
        }

        System.out.println(answer);

    }
}
