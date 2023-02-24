import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        int startIdx = 0;
        int endIdx = N-1;
        int sum = numbers[startIdx] + numbers[endIdx];
        int count = 0;

        while(startIdx < endIdx){

            if (sum == M){
                count++;
                sum = sum - numbers[startIdx] + numbers[++startIdx] - numbers[endIdx] + numbers[--endIdx];
            }else if(sum < M){
                sum = sum - numbers[startIdx] + numbers[++startIdx];
            }else{
                sum = sum - numbers[endIdx] + numbers[--endIdx];
            }
        }

        System.out.println(count);

        br.close();
    }
}
