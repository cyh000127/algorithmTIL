import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		// N일차 까지 벌 수 있는 최대 최대 Pi를 구하시오
		// 일차 별로 상담에 필요한 날짜를 모아놓은 배열
		int[] t = new int[T];
		int[] p = new int[T];
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		// dp는 여태까지의 최고 이득
		int[] dp = new int[T + 1];

		for (int i = 0; i < T; i++) {
			// i일차에 시작하는 일이 퇴사일을 넘어가지 않을때 === i + t[i]
			// i일차에 일을시작해서 끝나는 시간에 값을 넣기
			if (i + t[i] <= T) {
				dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
			}
//			System.out.println(Arrays.toString(dp));
			// 여태까지 일한게 이익이 더 큰지(쉬어갈지) 판단
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		System.out.println(dp[T]);

	}
}