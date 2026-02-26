import java.util.*;
import java.io.*;

/**
 * 11585 속타는 저녁 메뉴
 */
public class Main {
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 원형룰렛을 돌렸을 때 고기가 나올 확률을 구해라
		// 룰렛은 무조건 어느 하나만을 가리키는 것을 보장한다.
		// 분자가 0이되는 경우는 없다
		// 기약분수 형태로 출력하고, 100%라면 1/1을 출력하라

		// 그러니까 첫 줄의 문장이
		// 둘째 줄의 문장에서 (돌림판) 나타나면 고기를 먹는다는거지 ?

		N = Integer.parseInt(br.readLine());

		// Char 배열 선언
		char[] first = new char[N];
		char[] second = new char[2 * N];

		String str;
		str = br.readLine();
		for (int i = 0; i < N; i++) {
			first[i] = str.charAt(i * 2);
		}

		str = br.readLine();
		
		// 돌림판이기 때문에 
		for (int i = 0; i < N; i++) {
			second[i] = str.charAt(i * 2);
			second[i + N] = str.charAt(i * 2);
		}

		kmp(first, second);
	}

	private static void kmp(char[] first, char[] second) {
		// length == N;
		int idx = 0;
		int[] Pi = findPi(first);

		// 문장 발견 계산 cnt
		int cnt = 0;
		for (int i = 1; i < 2 * N; i++) {
			while (idx > 0 && second[i] != second[idx]) {
				idx = Pi[idx - 1];
			}

			if (second[i] == second[idx]) {
				idx++;
			}

			if (idx == N) {
				cnt++;
				idx = Pi[idx - 1];
			}
		}
		// 다 끝난 후 기약분수로 변환
		// 기약분수는 최대공약수로 나누어야함
		int g = gcd(cnt, N);
		
		// 출력
		System.out.println((cnt / g) + "/" + (N / g));
	}

	// 최대공약수 계산 로직
	private static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	private static int[] findPi(char[] first) {
		// length == N
		int idx = 0;
		int[] Pi = new int[N];

		for (int i = 1; i < N; i++) {
			while (idx > 0 && first[i] != first[idx]) {
				idx = Pi[idx - 1];
			}

			if (first[i] == first[idx]) {
				Pi[i] = ++idx;
			}
		}
		return Pi;
	}
}