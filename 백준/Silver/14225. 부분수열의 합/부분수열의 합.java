import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static Set<Integer> sumSet = new HashSet<>();

    public static void main(String[] args) throws IOException {

        initInput();
        dfs(0, 0);
        System.out.println(getMinImpossible());
    }

    static int getMinImpossible(){
        int target = 1;
        while(sumSet.contains(target)){
            target++;
        }
        return target;
    }

    static void dfs(int depth, int sum){

        if(depth == N){
            sumSet.add(sum);
            return;
        }

        // 선택할지, 선택하지 않을지
        dfs(depth + 1, sum);
        dfs(depth + 1, sum + arr[depth]);
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }
}
