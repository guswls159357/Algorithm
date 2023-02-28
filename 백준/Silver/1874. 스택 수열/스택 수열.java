import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int curNumber = 1;
        int seqNumber;
        for(int i = 0 ; i < N ; i++){
            seqNumber = Integer.parseInt(br.readLine());

            if(curNumber < seqNumber){
                for(int j = curNumber ; j <= seqNumber ; j++){
                    stack.push(j);
                    result.append("+").append("\n");
                }
                stack.pop();
                result.append("-").append("\n");
                curNumber = seqNumber + 1;
            }else if(curNumber == seqNumber){
                result.append("+").append("\n");
                result.append("-").append("\n");
                curNumber++;
            }else if(curNumber > seqNumber){
                if(stack.peek() == seqNumber){
                    stack.pop();
                    result.append("-").append("\n");
                }else{
                    System.out.println("NO");
                    System.exit(0);
                }
            }
        }

        System.out.println(result);

        br.close();
    }

}
