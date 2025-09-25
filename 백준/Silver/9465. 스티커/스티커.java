import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			int[][] board = new int[2][N];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			int[][] dp = new int[2][N];

			dp[0][0] = board[0][0];
			dp[1][0] = board[1][0];

			if (N >= 2) {
				dp[0][1] = dp[1][0] + board[0][1];
				dp[1][1] = dp[0][0] + board[1][1];
			}
			int ans = 0;
			for (int i = 2; i < N; i++) {
				for (int k = 0; k < 2; k++) {
					int a = k - 1 >= 0 ? 0 : 1;
					dp[k][i] = Math.max(dp[a][i-1] + board[k][i], dp[a][i - 2] + board[k][i]);

				}
			}

			for (int k = 0; k < 2; k++) {
				ans = Math.max(ans, dp[k][N - 1]);
			}
			System.out.println(ans);
		}
	}
}