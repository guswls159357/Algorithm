import java.io.*;
import java.util.*;

public class Main {

    static String str;

    public static void main(String[] args) throws IOException {

        initInput();

        System.out.println(getCount());
    }

    static int getCount() {

        String[] split = str.split(" ");
        int cnt = 0;
        for(String s : split){
            if(!Objects.equals(s, "")) cnt++;
        }

        return cnt;
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        br.close();
    }

}
