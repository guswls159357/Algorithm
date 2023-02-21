import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        char[] inputChars = input.toCharArray();
        List<Integer> numbers = Arrays.stream(input.split("-|[+]"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        long result = numbers.get(0);
        int length = inputChars.length;
        int operCnt = 1;
        boolean existsMinus = false;

        for(char c : inputChars){
            if(c == '-'){
                result -= numbers.get(operCnt++);
                existsMinus = true;
            }else if(c == '+'){
                if(existsMinus) result -= numbers.get(operCnt++);
                else result += numbers.get(operCnt++);
            }
        }

        System.out.println(result);
    }
}
