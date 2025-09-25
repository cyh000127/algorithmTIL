import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		long[] dp = new long[101];

		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;

		for (int i = 6; i <= 100; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
		}
	}
}