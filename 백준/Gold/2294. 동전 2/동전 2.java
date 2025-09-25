import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 동전 종류
		int k = Integer.parseInt(st.nextToken()); // 원하는 합 k

		int[] coin = new int[n + 1];
		long[] dp = new long[k + 1];

		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]= 0;
		for (int i = 0; i <= n; i++) {
			for (int j = coin[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
			}
		}
		if (dp[k] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else
			System.out.println(dp[k]);
	}
}