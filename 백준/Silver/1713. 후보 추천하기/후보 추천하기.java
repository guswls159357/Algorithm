import java.io.*;
import java.util.*;

public class Main {

    static class Student implements Comparable<Student>{
        int number;
        int vote;
        int registerTime;

        public Student(int number, int vote, int registerTime) {
            this.number = number;
            this.vote = vote;
            this.registerTime = registerTime;
        }

        @Override
        public int compareTo(Student o) {
            if(this.vote == o.vote){
                return this.registerTime - o.registerTime;
            }else return this.vote - o.vote;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "number=" + number +
                    ", vote=" + vote +
                    ", registerTime=" + registerTime +
                    '}';
        }
    }

    static int maxSize;
    static int voteCnt;
    static int[] votes;
    static PriorityQueue<Student> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        initInput();

        getAnswer();
    }

    static void getAnswer(){

        for(int i = 0 ; i < voteCnt ; i++){
            voteToStudent(votes[i], i);
        }

        StringBuilder sb = new StringBuilder();
        priorityQueue.stream()
                .map(student -> student.number)
                .sorted()
                .forEach(num -> sb.append(num).append(" "));

        System.out.println(sb);
    }

    static void voteToStudent(int number, int time){

        // 만약 사진틀에 이미 존재한다면
        for(Student s : priorityQueue){
            if(s.number == number) {
                priorityQueue.remove(s);
                s.vote++;
                priorityQueue.add(s);
                return;
            }
        }

        // 사진틀에 없고, 자리가 없을 때
        if(priorityQueue.size() >= maxSize) priorityQueue.poll();


        // 사진틀에 추가
        priorityQueue.add(new Student(number, 1, time));
    }

    static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        maxSize = Integer.parseInt(br.readLine());
        voteCnt = Integer.parseInt(br.readLine());
        votes = new int[voteCnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < voteCnt ; i++){
            votes[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

}
