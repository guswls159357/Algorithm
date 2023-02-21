import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int target = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());
        int count = 0;

        while(number >= target){
            count++;
            if(number == target){
                System.out.println(count);
                System.exit(0);
            }

            if(number % 10 == 1) number /= 10;
            else if(number % 2 == 0) number /= 2;
            else {
                System.out.println(-1);
                System.exit(0);
            }
        }

        System.out.println(-1);

    }
}
