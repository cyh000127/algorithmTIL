import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 백준
		// 11726. 2xn 타일링

		// n이 주어진다.
		// 10007로 나눈 나머지를 출력하라

		// 1x2, 2x1 타일 두가지가 있음
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];

		dp[1] = 1; // 2x1 타일링 방법은 1가지
		dp[2] = 2; // 2x2 타일링 방법은 2가지

		// 점화식: D[n] = D[n-1] + D[n-2]
		for (int i = 3; i <= n; i++) {
			// 이전 값들을 더할 때마다 나머지 연산을 수행
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}

		System.out.println(dp[n]);
	}
}