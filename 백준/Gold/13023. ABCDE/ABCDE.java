import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    static List<List<Integer>> checkList = new ArrayList<>();

    static boolean visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        initCheckList();

        visited = new boolean[N];

        int f1, f2;

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());

            f1 = Integer.parseInt(st.nextToken());
            f2 = Integer.parseInt(st.nextToken());

            checkList.get(f1).add(f2);
            checkList.get(f2).add(f1);
        }

        int length;
        List<Integer> tmpList;
        int tmp;

        for(int i = 0 ; i < N ; i++){

            tmpList = checkList.get(i);

            length = tmpList.size();

            visited[i] = true;
            for(int j = 0 ; j < length ; j++){
                tmp = tmpList.get(j);
                visited[tmp] = true;
                dfs(i, tmp, 1);
                visited[tmp] = false;
            }
            visited[i] = false;
        }

        System.out.println(0);

    }

    static void dfs(int f1, int f2, int depth){

        if(depth == 4){
            System.out.println(1);
            System.exit(0);
        }

        List<Integer> list = checkList.get(f2);

        int length = list.size();
        int tmp;

        for(int i = 0 ; i < length ; i++){

            tmp = list.get(i);
            if(!visited[tmp]) {
                visited[tmp] = true;
                dfs(f2, tmp, depth + 1);
                visited[tmp] = false;
            }
        }

        return;
    }

    public static void initCheckList(){

        for(int i = 0 ; i < N ; i++){
            checkList.add(new ArrayList<>());
        }
    }
}