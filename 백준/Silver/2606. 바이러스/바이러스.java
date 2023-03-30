
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());

        boolean map[][] = new boolean[cnt+1][cnt+1];

        StringTokenizer st;
        int tmp1;
        int tmp2;

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            tmp1 = Integer.parseInt(st.nextToken());
            tmp2 = Integer.parseInt(st.nextToken());

            map[tmp1][tmp2] = true;
            map[tmp2][tmp1] = true;
        }

        boolean visited[] = new boolean[cnt+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()){

            int num = queue.poll();

            for(int i = 1 ; i <= cnt ; i++){
                if(map[num][i] && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        int result = 0;
        for(int i = 2 ; i <= cnt ; i++){
            if(visited[i]) result++;
        }

        System.out.println(result);
    }

}
