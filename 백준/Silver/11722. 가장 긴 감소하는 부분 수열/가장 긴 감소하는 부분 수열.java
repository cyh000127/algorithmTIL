import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 백준
		// 11722. 가장 긴 감소하는 부분 수열

		// 수열 A가 주어졌을 때 가장 긴 감소하는 부분 수열을 구하는 프로그램

		int A = Integer.parseInt(br.readLine()); // 수열 A의 길이

		int[] arr = new int[A + 1];
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

		}

		// 뒤에서 부터 할거임
		int[] dp = new int[A + 1];
		
		// 기본 길이가 1이기 때문에 배열에 1을 채워줌
		Arrays.fill(dp, 1);
		
		for (int i = A - 1; i > 0; i--) {
			for (int j = i; j <= A; j++) {
				if (arr[i] > arr[j]) { // 뒤에 수보다 크다면
					dp[i] = Math.max(dp[i], dp[j] + 1); // 그 이전 dp와 지금 자신의 값을 비교
					// 더 높은걸로 저장함

				}
			}
		}

		int ans = 0;
		// 가장 긴거 찾기
		for (int i = 1; i <= A; i++) {
//			System.out.println("i=" + i + " " + dp[i] + " ");
			ans = Math.max(ans, dp[i]);
		}

		System.out.println(ans); //
	}
}