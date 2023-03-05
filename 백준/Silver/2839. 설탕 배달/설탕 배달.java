import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer input = Integer.valueOf(st.nextToken());

        int count=0;

        while(true){

            if(input%5==0){
                count+=input/5;
                bw.write(String.valueOf(count));
                break;
            }
            else{
                input-=3;
                count++;
            }

            if(input<0){
                bw.write(String.valueOf(-1));
                break;
            }
        }

        bw.flush();
        bw.close();

    }

}
