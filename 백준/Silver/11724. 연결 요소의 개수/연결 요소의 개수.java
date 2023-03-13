import java.io.*;
import java.util.*;

public class Main {

    static int N, M, cnt = 0;
    static boolean[] visited;

    static List<Integer>[] connectedList;

    public static void main(String[] args) throws IOException {

        initInput();

        for(int i = 1 ; i <= N ; i++){
            if(!visited[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    static void dfs(int start){

        if(visited[start]) return;

        visited[start] = true;

        for(int num : connectedList[start]){
            if(!visited[num]){
                dfs(num);
            }
        }
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        connectedList = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; i++){
            connectedList[i] = new ArrayList<>();
        }

        int first, second;
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());

            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());

            putToMap(first, second);
        }

        br.close();
    }

    static void putToMap(int num1, int num2){


        connectedList[num1].add(num2);
        connectedList[num2].add(num1);
    }

}
