import java.io.*;

public class Main {

    static int count[] = new int[26];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int length = s.length();


        int idx = 0;

        for(int i = 0 ; i < length ; i++){
            idx = s.charAt(i) - 'A';
            count[idx]++;
        }

        int oddCnt = 0;

        for(int i = 0 ; i < 26 ; i++){
            if(count[i] % 2 == 1) oddCnt++;
            if(oddCnt >= 2) break;
        }

        if(oddCnt >= 2){
            System.out.println("I'm Sorry Hansoo");
        }else if(oddCnt == 0){

            StringBuilder sb = new StringBuilder();
            idx = 0;
            char c;
            while(sb.length() < length / 2){
                if(count[idx] >= 2){
                    c = (char) (idx + 'A');
                    sb.append(c);
                    count[idx]-=2;
                }else idx++;
            }
            System.out.print(sb);
            System.out.println(sb.reverse());

        }else {
            StringBuilder sb = new StringBuilder();
            idx = 0;
            char c;
            while(sb.length() < length / 2){
                if(count[idx] >= 2){
                    c = (char) (idx + 'A');
                    sb.append(c);
                    count[idx]-=2;
                }else idx++;
            }
            System.out.println(sb.toString() + getOdd() + sb.reverse());
        }

    }

    public static char getOdd(){
        for(int i = 0 ; i < 26 ; i++){
            if(count[i] % 2 == 1) return (char)(i + 'A');
        }

        return ' ';
    }

}
