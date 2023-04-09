import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        initInput();
        System.out.println(getMinAnswer());
    }

    static int getMinAnswer(){

        int start = 0;
        int end = 1_000_000_000;

        for(int i = 1 ; i <= N ; i++){
            if(start < arr[i]) start = arr[i];
        }

        int lowerbound = 0;

        while(start <= end){
            int mid = (start + end) / 2;
            if(isPossibleLength(mid)){
                lowerbound = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return lowerbound;
    }

    // 5 9 6 8 7 7 5
    static boolean isPossibleLength(int length){

        int count = 1;
        int sum = 0;

        for(int i = 1 ; i <= N ; i++){
            if(sum + arr[i] > length){
                count++;
                sum = arr[i];
            }else{
                sum += arr[i];
            }
        }

        return count <= M;
    }


    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }
}
