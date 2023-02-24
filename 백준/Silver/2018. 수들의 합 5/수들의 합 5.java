import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 1;
        int sum = 1;
        int count = 1;

        while(end != N){

            if(N > sum){
                sum += ++end;
            }else if(N == sum){
                count++;
                sum += ++end;
            }else{
                sum -= start++;
            }
        }

        System.out.println(count);

        br.close();
    }
}
