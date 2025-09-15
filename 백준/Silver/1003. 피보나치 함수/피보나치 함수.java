import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			// N번 할 때 0, 1 이 몇번씩 호출 되는지 구해라
			int N = Integer.parseInt(br.readLine());

			sb.append(fibonacciZero(N)).append(" ").append(fibonacciOne(N));
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}

	static int[] memo2 = new int[41]; // 0~41 까지의 메모이제이션

	private static int fibonacciZero(int n) {
		if (n == 0) // n이 1보다 작거나 같다면 n을 리턴해라
			return 1;

		if (n == 1)
			return 0;

		if (memo2[n] != 0)
			return memo2[n];

		return memo2[n] = fibonacciZero(n - 1) + fibonacciZero(n - 2);
	}

	static int[] memo = new int[41]; // 0~41 까지의 메모이제이션

	private static int fibonacciOne(int n) {
		if (n == 0) // n이 1보다 작거나 같다면 n을 리턴해라
			return 0;

		if (n == 1)
			return 1;

		if (memo[n] != 0)
			return memo[n];

		return memo[n] = fibonacciOne(n - 1) + fibonacciOne(n - 2);

	}
}
