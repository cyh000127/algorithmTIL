import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] value = new int[n + 1];
		int[] dp = new int[k + 1];
		dp[0] = 1;

		for (int i = 0; i < n; i++) {
			value[i] = Integer.parseInt(br.readLine());
			for (int j = value[i]; j <= k; j++) {
				dp[j] += dp[j - value[i]];
			}

		}
		System.out.println(dp[k]);
	}
}