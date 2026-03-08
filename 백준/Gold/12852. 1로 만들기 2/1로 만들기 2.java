import java.util.*;
import java.io.*;

/**
 * 12852 1로 만들기 2
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1. 3으로 나눈다
		// 2. 2로 나눈다
		// 3. 1을 뺀다.

		// 이 세개의 규칙을 반복해서 1을 만들거임
		// 적은 시도로 1을 만들면 그 숫자를 출력
		// + 어떤 방식이었는지도 출력
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1]; // 문제에서 10^6으로 줌

//		dp[1] = 0;
//		dp[2] = 1; // 2로 나누거나 1을 뺌
//		dp[3] = 1; // 3으로 나눔
//		dp[4] = 2; // 1빼고 3 나누기 or 2나누고 1빼기
//		dp[5] = 3; // 1빼고 2 나누고 1빼기
//		dp[6] = 2; // 3나누고 2나누기

		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1; // 1 빼는 연산
			if (i % 2 == 0) // 2 나누는 연산
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			if (i % 3 == 0) // 3 나누는 연산
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
		}
		sb.append(dp[N]).append("\n");

		// 역추적
		while (N > 0) {
			sb.append(N).append(" ");
			if (N == 1)
				break; // 탈출조건
			// 역으로 계산하면서 N값을 실시간으로 업데이트 한다.
			if (N % 3 == 0 && dp[N / 3] == dp[N] - 1) {
				N /= 3; // N값을 실시간으로 업데이트
			} else if (N % 2 == 0 && dp[N / 2] == dp[N] - 1) {
				N /= 2; // N값을 실시간으로 업데이트
			} else {
				N -= 1;
			}
		}

		System.out.println(sb.toString());
	}
}
