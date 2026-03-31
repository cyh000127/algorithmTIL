import java.util.*;
import java.io.*;

/*
 * 루미 상관 수
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> nums = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>();
		int[] XxX = new int[10]; // 앞뒤를 곱하기 위한 것

		XxX[0] = 1;
		for (int i = 1; i < 10; i++) {
			XxX[i] = XxX[i - 1] * 10;
		}

		for (int i = 1; i <= 9; i++) {
			int half = i / 2;

			if (i == 1) {
				for (int d = 1; d <= 9; d++) {
					nums.add(d);
				}
				continue;
			}

			if (i % 2 == 0) {
				int start = XxX[half - 1];
				int end = XxX[half] - 1;
				int mul = XxX[half] + 1;

				for (int x = start; x <= end; x++) {
					nums.add(x * mul);
				}
			} else {
				int start = XxX[half - 1];
				int end = XxX[half] - 1;

				for (int x = start; x <= end; x++) {
					for (int mid = 0; mid <= 9; mid++) {
						int value = x * XxX[half + 1] + mid * XxX[half] + x;
						nums.add(value);
					}
				}
			}
		}

		set.addAll(nums);

		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int ans = 0;

			for (int x : nums) {
				if (set.contains(n - x)) {
					ans++;
				}
			}

			sb.append(ans).append('\n');
		}

		System.out.print(sb);
	}
}
