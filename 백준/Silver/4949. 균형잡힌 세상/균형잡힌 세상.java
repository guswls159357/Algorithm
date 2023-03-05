import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;

        StringBuilder sb = new StringBuilder();

        while(!(str = br.readLine()).equals(".")){
            if(isBalanceStr(str)) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static boolean isBalanceStr(String str){

        Stack<Character> stack = new Stack<>();

        int length = str.length() - 1;
        char c;

        for (int i = 0 ; i < length ; i++){
            c = str.charAt(i);

            if(c == '(' || c == '[') stack.push(c);
            else if(c == ')'){
                if(stack.isEmpty() || stack.peek() != '(') return false;
                else stack.pop();
            }else if(c == ']'){
                if(stack.isEmpty() || stack.peek() != '[') return false;
                else stack.pop();
            }else continue;
        }

        if(stack.isEmpty()) return true;
        return false;
    }
}
