import java.io.*;
import java.util.*;

public class Main {
	static boolean[] isprime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 0이 입력되기 전까지 하나의 수에 대해
		// 소수의 합으로 나타내는 경우를 만들어서 써라

		// 4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다는 이론을 100만 언더의 자릿수에서 증명
		isprime = new boolean[1000001];
		prime(1000000);

		StringBuilder sb = new StringBuilder();
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}

			boolean found = false;

			// 골드바흐의 추측 : 4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
			for (int a = 3; a <= N / 2; a += 2) { // 소수는 무조건 홀수임
				// a가 소수이고, (N - a)도 소수인지 확인
				if (!isprime[a] && !isprime[N - a]) {
					sb.append(N).append(" = ").append(a).append(" + ").append(N - a).append("\n");
					found = true;
					break; // 가장 먼저 찾은 쌍이 답
				}
			}

			if (!found) {
				// 이 부분은 골드바흐의 추측에 따라 실행되지 않음
				sb.append("Goldbach's conjecture is wrong.\n");
			}
		}
		System.out.print(sb); // 출력이 많을 경우 StringBuilder를 사용하는 것이 빠름
	}

	private static void prime(int n) {
		isprime[0] = isprime[1] = true; // 소수인 경우 false

		for (int i = 2; i * i <= n; i++) {
			if (!isprime[i]) {
				for (int j = i * i; j < n; j += i) {
					isprime[j] = true;
				}
			}
		}
	}
}