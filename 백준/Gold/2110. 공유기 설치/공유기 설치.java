import java.io.*;
import java.util.*;

public class Main {

    static int N, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        initInput();
        System.out.println(getMaxDistance());
    }

    static int getMaxDistance(){

        int start = 0;
        int end = 1000000000;
        int maxDistance = end + 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(isPossible(mid)){
                maxDistance = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return maxDistance;
    }

    static boolean isPossible(int distance){

        // 첫 번째 위치에 놓음
        int count = 1;
        int idx = 1;

        while(idx <= N){
            int lowerbound = getLowerbound(idx + 1, N, arr[idx] + distance);
            if(lowerbound > N) break;
            idx = lowerbound;
            count++;
        }

        return count >= C;
    }

    static int getLowerbound(int start, int end, int target){

        int lowerbound = end + 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(arr[mid] >= target){
                lowerbound = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return lowerbound;
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, 1, N + 1);

        br.close();
    }
}
