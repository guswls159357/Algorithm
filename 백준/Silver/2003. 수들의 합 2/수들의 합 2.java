import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		initInput();
		System.out.println(getCount());
	}

	static int getCount() {

		int start = 0, end = 0;
		int sum = 0;
		int count = 0;

		while (start <= end && end <= N) {
			if (sum == M) {
				count++;
				sum -= arr[start++];
			} else if (sum < M) {
				if (end == N)
					break;
				sum += arr[end++];
			} else {
				sum -= arr[start++];
			}
		}

		return count;
	}

	static void initInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		br.close();
	}
}
