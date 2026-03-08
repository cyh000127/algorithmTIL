import java.util.*;
import java.io.*;

/**
 * 11053 가장 긴 증가하는 부분 수열
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 수열이 주어질때
		// 가장 긴 증가하는 부분 수열의 길이를 출력하라

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n];
		// 각 배열의 길이는 1이기 때문에 1을 채움
		Arrays.fill(dp, 1);

		int max = 1;
		// 1부터 시작
		for (int i = 1; i < n; i++) {
			// 0부터 시작해서 i 까지
			for (int j = 0; j < i; j++) {
				// arr[i]가 이전 수 보다 크다면
				if (arr[i] > arr[j]) {
					// dp[i]의 값을 갱신 
					dp[i] = Math.max(dp[i], dp[j] + 1);
					if (dp[i] > max) {
						max = dp[i];
					}
				}
			}
		}
		System.out.println(max);
	}
}
