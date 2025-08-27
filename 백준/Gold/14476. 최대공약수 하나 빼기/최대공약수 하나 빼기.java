import java.io.*;
import java.util.*;

public class Main {
	static int b;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정수의 개수 N을 입력받습니다.
		int N = Integer.parseInt(br.readLine());

		// N개의 수를 저장할 배열을 만듭니다.
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 왼쪽부터의 누적 GCD를 저장할 배열
		int[] leftGcd = new int[N];
		// 오른쪽부터의 누적 GCD를 저장할 배열
		int[] rightGcd = new int[N];

		// 첫 번째 요소는 배열의 첫 번째 값으로 초기화합니다.
		leftGcd[0] = arr[0];
		// 마지막 요소는 배열의 마지막 값으로 초기화합니다.
		rightGcd[N - 1] = arr[N - 1];

		// 왼쪽 누적 GCD 배열을 채웁니다.
		// i번째 요소의 GCD는 (i-1)번째까지의 누적 GCD와 현재 요소의 GCD입니다.
		for (int i = 1; i < N; i++) {
			leftGcd[i] = gcd(leftGcd[i - 1], arr[i]);
		}

		// 오른쪽 누적 GCD 배열을 채웁니다.
		// i번째 요소의 GCD는 (i+1)번째부터의 누적 GCD와 현재 요소의 GCD입니다.
		for (int i = N - 2; i >= 0; i--) {
			rightGcd[i] = gcd(rightGcd[i + 1], arr[i]);
		}

		int maxGcd = 0; // 찾은 최대공약수 중 가장 큰 값
		int removedNum = -1; // 제외된 숫자

		// 각 요소를 하나씩 제외하면서 최대공약수를 찾습니다.
		for (int i = 0; i < N; i++) {
			int currentGcd = 0;

			// i번째 수를 제외했을 때의 최대공약수 계산
			if (i == 0) { // 첫 번째 수를 제외한 경우
				currentGcd = rightGcd[i + 1];
			} else if (i == N - 1) { // 마지막 수를 제외한 경우
				currentGcd = leftGcd[i - 1];
			} else { // 중간의 수를 제외한 경우
				currentGcd = gcd(leftGcd[i - 1], rightGcd[i + 1]);
			}

			// 조건 확인: (나머지 수들의 GCD)가 (제외된 수)의 약수가 아니어야 합니다.
			// 그리고 현재 GCD가 이전의 최대 GCD보다 커야 합니다.
			if (arr[i] % currentGcd != 0 && currentGcd > maxGcd) {
				maxGcd = currentGcd;
				removedNum = arr[i];
			}
		}

		if (removedNum == -1) {
			System.out.println(-1);
		} else {
			System.out.println(maxGcd + " " + removedNum);
		}
	}

	// 유클리드 호제법으로 최대공약수(GCD)를 계산하는 메서드
	private static int gcd(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}

}