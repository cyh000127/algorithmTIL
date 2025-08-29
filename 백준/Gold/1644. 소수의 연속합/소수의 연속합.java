import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static boolean[] isprime;
	static int N, x; // arr의 길이 == arr 배열의 길이
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 수 하나만 입력됨
		// 그 수를 소수의 합으로 나타낼 수 있는 경우의 수를 계산하여라

		N = Integer.parseInt(br.readLine());
		isprime = new boolean[N + 1]; // 자기 자신도 포함할 수 있으므로

		// N 보다 작은 소수들을 구한다.
		// 연속된 소수의 합이 해당 값이 되는 수를 찾기

		prime(N);

		for (int i = 0; i <= N; i++) {
			if (!isprime[i]) {
				cnt++;
			}
		}
		arr = new int[cnt];

		int x = 0;
		for (int i = 0; i <= N; i++) {
			if (!isprime[i]) {
				arr[x++] = i;
//				System.out.println((x-1)+" "+i);
			}
		}

		int ans = 0;

		for (int i = 0; i < arr.length; i++) { // i의 범위를 끝까지 탐색하도록 수정
			int sumAll = 0;
			for (int j = i; j < arr.length; j++) {
				sumAll += arr[j];

				// 1. 합이 정확히 N과 같아지면 정답을 올린다.
				if (sumAll == N) {
					ans++;
					// 찾을시 ans++하고 break;
					break;
				}

				// 2. 합이 N을 넘어버리면 더 더해봐야 소용없다.
				if (sumAll > N) {
					break;
				}
			}
		}

		System.out.println(ans);
	}

	private static void prime(int n) {
		isprime[1] = isprime[0] = true; // 기본형이 false이기 떄문에 false를 소수로 인식

		for (int i = 2; i * i <= n; i++) {
			if (!isprime[i]) {
				for (int j = i * i; j <= n; j += i) {
					isprime[j] = true;
				}
			}

		}

	}
}