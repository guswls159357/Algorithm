import java.io.*;
import java.util.*;

public class Main {

    static int N, targetCount;
    static long max = Integer.MIN_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        initInput();
        System.out.println(getMaxLength());
    }

    static long getMaxLength(){

        long start = 1;
        long end = max + 1;
        long lowerbound = end;

        while(start <= end){

            long mid = (start + end) / 2;
            if(isPossibleLength(mid)){
                // 길이를 늘려도 된다.
                lowerbound = mid;
                start = mid + 1;
            }else{
                // 길이를 줄여야 한다.
                end = mid - 1;
            }
        }

        return lowerbound;
    }

    static boolean isPossibleLength(long length){

        int count = 0;
        for(int i = 0 ; i < N ; i++){
            count += arr[i] / length;
        }

        return count >= targetCount;
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        targetCount = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > max) max = arr[i];
        }
        Arrays.sort(arr);

        br.close();
    }
}
