import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int targetIdx = 0;
        int targetNumber;
        int startIdx;
        int endIdx;
        long sum;
        int count = 0;

        while(targetIdx < N){

            targetNumber = arr[targetIdx];
            startIdx = 0;
            endIdx = N - 1;
            sum = arr[startIdx] + arr[endIdx];

            while(startIdx < endIdx){
                if(startIdx == targetIdx) {
                    sum = sum - arr[startIdx] + arr[++startIdx];
                }
                else if(endIdx == targetIdx) {
                    sum = sum - arr[endIdx] + arr[--endIdx];
                }
                else{
                    if(sum == targetNumber){
                        count++;
                        break;
                    }else if(sum < targetNumber){
                        sum = sum - arr[startIdx] + arr[++startIdx];
                    }else{
                        sum = sum - arr[endIdx] + arr[--endIdx];
                    }
                }
            }

            targetIdx++;
        }


        System.out.println(count);

        br.close();
    }
}
