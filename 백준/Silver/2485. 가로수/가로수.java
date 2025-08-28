import java.io.*;
import java.util.*;

public class Main {
	static int avglen = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 가로수가 N개 심어져있음
		// 가로수를 a개 더 심어서 기존 가로수들과의 간격이 같아지면 됨
		// a 의 최소 개수를 구하여라

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N - 1];

		int x = Integer.parseInt(br.readLine());

		// 가까운 순서대로 입력이 주어짐
		for (int i = 0; i < N - 1; i++) {
			int y = Integer.parseInt(br.readLine());
			arr[i] = y - x;
			x = y;
		}
		// gcd를 이용해 최소 공배수를 찾아줘야함
		avglen = gcd(arr);
		int ans = 0;

		for (int i = 0; i < N - 1; i++) {
			ans += arr[i] / avglen - 1; // 나무를 구한 후 1씩 빼줘야함
		}
//		System.out.println(avglen); // 디버그용
		System.out.println(ans);
	}

	// 배열 gcd
	private static int gcd(int[] arr) {
		int result = arr[0];
		for (int i = 0; i < arr.length; i++) {
			result = gcd(result, arr[i]);
		}
		return result;

	}

	// gcd
	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}