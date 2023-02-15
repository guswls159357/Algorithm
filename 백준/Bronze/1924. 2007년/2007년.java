import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.println(getDayOfWeek(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    static String getDayOfWeek(int month, int day) {

        int totalDays = -1;

        Map<Integer, Integer> daysOfMonth = initMap();
        String[] dayOfWeek = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        if (month == 1) {
            totalDays += day;
        } else {

            for (int before = 1; before < month; before++) {
                totalDays += daysOfMonth.get(before);
            }

            totalDays += day;
        }

        if (totalDays == 0) return dayOfWeek[0];
        else return dayOfWeek[totalDays % 7];
    }

    static Map<Integer, Integer> initMap() {

        Map<Integer, Integer> daysOfMonth = new HashMap<>();

        daysOfMonth.put(2, 28);
        daysOfMonth.put(1, 31);
        daysOfMonth.put(3, 31);
        daysOfMonth.put(5, 31);
        daysOfMonth.put(7, 31);
        daysOfMonth.put(8, 31);
        daysOfMonth.put(10, 31);
        daysOfMonth.put(12, 31);
        daysOfMonth.put(4, 30);
        daysOfMonth.put(6, 30);
        daysOfMonth.put(9, 30);
        daysOfMonth.put(11, 30);

        return daysOfMonth;
    }
}
