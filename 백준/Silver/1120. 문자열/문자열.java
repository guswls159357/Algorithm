import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        if(A.length() < B.length()){
            System.out.println(getMinDifference(B, A));
        }else{
            System.out.println(getMinDifference(A,B));
        }

    }


    static int getMinDifference(String longStr, String shortStr){

        int length1 = longStr.length();
        int length2 = shortStr.length();

        int min = Integer.MAX_VALUE;
        int tmp;
        int diff = length1 - length2;

        for (int offset = 0 ; offset <= diff ; offset++){
            tmp = getDiff(longStr, shortStr, offset, length2);
            if(tmp < min) min = tmp;
        }

        return min;
    }

    static int getDiff(String longStr, String shortStr, int offset, int shortStrLength){

        int count = 0;

        for (int i = 0; i < shortStrLength; i++) {
            if(shortStr.charAt(i) != longStr.charAt(i + offset)) count++;
        }

        return count;
    }

}
