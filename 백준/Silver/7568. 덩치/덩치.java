import java.io.*;
import java.util.*;

public class Main {

    static class Person implements Comparable<Person>{
        int height;
        int weight;
        int index;

        public Person(int weight, int height, int index) {
            this.height = height;
            this.weight = weight;
            this.index = index;
        }

        @Override
        public int compareTo(Person o) {
            if(this.height > o.height && this.weight > o.weight) return 1;
            return -1;
        }
    }

    static int N;
    static List<Person> personList = new ArrayList<>(N);

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            personList.add(new Person(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    i
            ));
        }

        int[] rank = new int[N];

        Person now;
        Person comparePerson;
        int cnt;
        for(int i = 0 ; i < N ; i++){
            cnt = 1;
            now = personList.get(i);
            for(int j = 0 ; j < N ; j++){
                comparePerson = personList.get(j);
                if(i!=j && comparePerson.compareTo(now) > 0) cnt++;
            }
            rank[now.index] = cnt;
        }

        for(int i : rank){
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

}
