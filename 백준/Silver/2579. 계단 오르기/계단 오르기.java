import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 백준
		// 2579. 계단 오르기

		// 1. 계단은 한번에 1 or 2 이동 가능
		// 2. 연속된 세개의 계단을 모두 밟으면 실패 (시작점은 포함 x)
		// 3. 마지막 도착 계단은 무조건 밟아야함
		// 계단에 점수가 써있을 때 그 점수의 합 을 구하는 문제
		int N = Integer.parseInt(br.readLine()); // 계단 개수

		int[] arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine()); // 계단 값 배정
		}

		// 점수의 최댓값을 구하기 위해서는 연속된 세개를 밟아서는 안된다는 조건 빼고 나머지를 모두 밟아야함
		// 가장 낮은 점수를 안밟기
		int[] dp = new int[N + 1];

		dp[0] = 0; // 시작은 0 점
		dp[1] = arr[1];
		if (N >= 2) { // N이 1로 주어지는 경우가 있기 때문에 2로 넣어줌 
			dp[2] = arr[1] + arr[2];
		}
		
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i]; // 3개의 계단중 하나를 밟지 않아야하기 때문에 dp는 계단 세개를
																				// 기준으로 반복됨
		}
		System.out.println(dp[N]);
	}

}