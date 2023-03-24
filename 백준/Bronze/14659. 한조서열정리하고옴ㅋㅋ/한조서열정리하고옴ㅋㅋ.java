import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        initInput();

        System.out.println(getMax());
    }

    static int getMax(){

        int max = 0;
        int curBow = arr[0];
        int cnt = 0;

        for(int i = 1 ; i < N ; i++) {

            if(curBow > arr[i]){
                cnt++;
            }else{
                max = Math.max(max, cnt);
                curBow = arr[i];
                cnt = 0;
            }
        }

        max = Math.max(max, cnt);
        return max;
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
