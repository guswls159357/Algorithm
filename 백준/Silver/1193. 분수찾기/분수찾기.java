import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int sum = 0;

        for(int i = 1 ; i <= 10000 ; i++){

            sum += i;

            if(N <= sum){
                int numberSum = i + 1;
                int startCnt = (sum -= i);
                int left;
                int right;

                if(numberSum % 2 == 1){
                    left = 0;
                    right = numberSum;
                    while(startCnt != N){
                        startCnt++;
                        left++;
                        right--;
                    }
                }else{
                    left = numberSum;
                    right = 0;
                    while(startCnt != N){
                        startCnt++;
                        left--;
                        right++;
                    }
                }

                sb.append(left).append("/").append(right);
                break;
            }
        }

        System.out.println(sb);

    }
}
