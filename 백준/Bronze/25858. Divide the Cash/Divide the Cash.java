import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		// 백준
		// 25858. Divide the Cash

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int reward = Integer.parseInt(st.nextToken());

		int sum = 0;
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(br.readLine());
			arr[i] = now;
			sum += now;

		}

		int avg = (reward / sum);

		for (int i = 0; i < n; i++) {
			System.out.println(arr[i] * avg);
		}
	}
}
