import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static StringBuilder sb = new StringBuilder();
	// 이동횟수 cnt
	static int cnt = 0;

	private static void hanoi(int n, int from, int to, int other) {
		if (n == 0) {
			return;
		}
		// 1. n-1개의 원판을 from -> other 로 옮김
		hanoi(n - 1, from, other, to);
		// 2. 가장 큰 원반을 from -> to
		sb.append(from).append(" ").append(to).append("\n");
		cnt++;
		// 3. other에 있던 원반들을 other -> to 로 옮김
		hanoi(n - 1, other, to, from);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N <= 20) {
			hanoi(N, 1, 3, 2);
			System.out.println(cnt);
			System.out.println(sb);
		} else {
			// N이 20보다 클 경우, 이동 횟수만 출력
			// 이동 횟수: 2^N - 1
			BigInteger moves = BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE);
			System.out.println(moves);
		}

	}
}
