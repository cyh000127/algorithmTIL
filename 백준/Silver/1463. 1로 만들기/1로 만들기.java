import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 백준
		// 1463. 1로 만들기

		int X = Integer.parseInt(br.readLine()); // target

		// 1. x 가 3으로 나누어 떨어지면 3으로 나눔
		// 2. x가 2로 나누어 떨어지면 2로 나눔
		// 3. x-1 을함

		// 셋 중 하나의 연산이 가능할때 최소로 실행하는 경우의 수를 출력하라
		int[] dp = new int[X + 1];

		dp[0] = dp[1] = 0;

		for (int i = 2; i <= X; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 1을 뺀값 vs 2를 나눈 값 비교
			}
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 1을 뺀값 vs 3을 나눈 값 비교

			}
		}
		System.out.println(dp[X]);
	}
}