import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long min = Long.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        long arr[] = new long[N];

        for(int i = 0 ; i < N ; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int lastIdxForEven = N - 1;
        int lastIdxForOdd = N - 2;

        if(N % 2 == 0){
            long tmp = 0;
            for(int i = 0 ; i < N / 2 ; i++){
                tmp = arr[i] + arr[lastIdxForEven - i];
                if(min <= tmp) min = tmp;
            }
        }else{
            long tmp = 0;
            for(int i = 0 ; i < N / 2 ; i++){
                tmp = arr[i] + arr[lastIdxForOdd - i];
                if(min <= tmp) min = tmp;
            }
            if(arr[lastIdxForEven] >= min) min = arr[lastIdxForEven];
        }

        System.out.println(min);
    }

}
