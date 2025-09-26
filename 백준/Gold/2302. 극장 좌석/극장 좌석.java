import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;

		// 백준
		// 2302. 극장 좌석

		// 자기 자리를 제외한 양옆도 앉을 수 있음
		// ex) 7번 -> 6 7 8

		// 좌석의 개수 N
		// 고정석의 개수 M
		// 고정석의 번호

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] dp = new int[41];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;

		for (int i = 4; i < 41; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		// 작은 수 부터 순서대로 입력이 들어오기 때문에
		// a -1, b-a-1, N-b 이런식으로 나눠서 생각
		int[] a = new int[M + 1];
		int curr = 1;
		for (int i = 0; i < M; i++) {
			int b = Integer.parseInt(br.readLine());
			a[i] = b - curr;
			curr = b + 1;
		}
		a[M] = N - curr + 1;


		int ans = 1;
		for (int i = 0; i < M + 1; i++) {
			if(a[i]==0) continue;
			ans *= dp[a[i]]; // 좌석들에 해당하는 dp를 곱하면 정답
		}
		System.out.println(ans);
	}
}