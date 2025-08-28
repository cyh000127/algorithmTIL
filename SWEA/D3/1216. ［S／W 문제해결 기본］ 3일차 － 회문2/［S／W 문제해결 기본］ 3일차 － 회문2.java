import java.util.*;
import java.io.*;
import java.lang.Integer;

public class Solution {
	static int maxPal = 0;

	public static void main(String[] args) throws IOException {
		// 런타임 측정 시작
//		long startTime = System.currentTimeMillis();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int test = 0; test<10; test++) {
			int T = Integer.parseInt(br.readLine());

			// 100x 100 평면 글자판
			// 가로, 세로 탐색해서 가장 긴 회문의 길이를 구하여라
			String[] arr = new String[100];

			for (int i = 0; i < 100; i++) {
				arr[i] = br.readLine();
			}
			maxPal = 0;
			isPalindrome(arr);

			// 런타임 측정 종료

			System.out.println("#" + T + " " + maxPal);
		}
//		long endTime = System.currentTimeMillis();
//		long runtime = endTime - startTime;
//		System.out.println("Runtime: " + runtime + "ms"); // 런타임 출력 (밀리초 단위)
	}

	// 기존 isPalindrome 메서드 (변경 없음)
	private static void isPalindrome(String[] arr) {
		for (int r = 0; r < 100; r++) {
			for (int i = 1; i < 99; i++) {
				int cnt = 0;
				int a = 0;
				if (arr[r].charAt(i) == arr[r].charAt(i + 1)) {
					a = 1;
					cnt = 2;
				} else if (arr[r].charAt(i - 1) == arr[r].charAt(i + 1)) {
					cnt = 1;
				}
				for (int j = 1; j < 50; j++) {
					if (i + j + a >= 100 || i - j < 0 || arr[r].charAt(i + j + a) != arr[r].charAt(i - j)) {
						maxPal = Math.max(maxPal, cnt);
						cnt = 0;
						break;
					}
					if (arr[r].charAt(i + j + a) == arr[r].charAt(i - j)) {
						cnt += 2;
					}
				}
			}
		}
		for (int r = 0; r < 100; r++) {
			for (int i = 1; i < 99; i++) {
				int cnt = 0;
				int a = 0;
				if (arr[i].charAt(r) == arr[i + 1].charAt(r)) {
					a = 1;
					cnt = 2;
				} else if (arr[i - 1].charAt(r) == arr[i + 1].charAt(r)) {
					cnt = 1;
				}
				for (int j = 1; j < 50; j++) {
					if (i - j < 0 || i + j + a >= 100 || arr[i + j + a].charAt(r) != arr[i - j].charAt(r)) {
						maxPal = Math.max(maxPal, cnt);
						cnt = 0;
						break;
					}
					if (arr[i - j].charAt(r) == arr[i + j + a].charAt(r)) {
						cnt += 2;
					}
				}
			}
		}
	}
}