import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;

		// 백준
		// 2133. 타일 채우기

		// 3 x N 크기의 벽을 2x1, 1x2 크기의 타일로 채우는 경우의 수를 구하자

		int N = Integer.parseInt(br.readLine());

		int ans = 0;

		int[] dp = new int[31];
		dp[0] = 1;
		dp[2] = 3;
//		dp[4] = 11;

		for (int i = 4; i < 31; i += 2) {
			for (int j = 0; j <= i - 4; j += 2) {
				dp[i] += dp[j] * 2;
			}
			dp[i] += dp[i - 2] * 3;
		}

		System.out.println(dp[N]);
	}
}