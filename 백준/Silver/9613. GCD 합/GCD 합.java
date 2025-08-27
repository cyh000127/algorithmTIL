import java.io.*;
import java.util.*;

public class Main {
	public static int gcd(int a, int b) {
		while (true) {
			int tmp = b;
			b = a % b;
			a = tmp;
			if (b == 0) break;
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			long ans = 0;// gcd 합을 저장할 변수 cnt
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());

			int[] arr = new int[a];
			for (int i = 0; i < a; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < a - 1; i++) {
				for (int j = i + 1; j < a; j++) {
					ans += gcd(arr[i], arr[j]);
				}
			}
			System.out.println(ans);
		}

	}
}
