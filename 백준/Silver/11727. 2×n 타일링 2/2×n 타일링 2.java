import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;

		long[] dp = new long[1001];

		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 3;

		for (int i = 3; i <= 1000; i++) {
			dp[i] = ((dp[i - 1])  + (2 * dp[i - 2]))%10007 ;
		}

		int N = Integer.parseInt(br.readLine());
		System.out.println(dp[N]);
	}
}