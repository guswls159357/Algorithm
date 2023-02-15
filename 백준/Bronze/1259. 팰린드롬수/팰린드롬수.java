import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();
        String s;

        while(!(s = br.readLine()).equals("0")){
            if(isPalindrome(s)) result.append("yes").append("\n");
            else result.append("no").append("\n");
        }

        System.out.println(result);
    }

    static boolean isPalindrome(String number){

        char[] numberChar = number.toCharArray();
        int length = numberChar.length;
        int mid = length / 2;

        for(int i = 0 ; i <= mid ; i++){
            if(numberChar[i] != numberChar[length - i - 1]){
                return false;
            }
        }

        return true;
    }
}
