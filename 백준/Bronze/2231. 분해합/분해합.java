import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer num = Integer.valueOf(st.nextToken());

        bw.write(String.valueOf(divSum(num)));
        bw.flush();
        bw.close();
    }

    static int divSum(int num){
        int digit=1;
        int tmp = num;
        while(tmp/10>=1){
            tmp/=10;
            digit+=1;
        }

        int start= num-9*digit;


        while(true){
            if(start+1==num) return 0;

            int divNumTmp = start;
            int total = start;
            while(divNumTmp>0){
                total+=divNumTmp%10;
                divNumTmp/=10;
            }
            if(total==num) return start;
            else start++;
        }
    }
}
