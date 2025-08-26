import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str1 = br.readLine();
		String str2 = br.readLine();

		int leng1 = str1.length();
		int leng2 = str2.length();

		char[] arr1 = new char[leng1 + 1];
		char[] arr2 = new char[leng2 + 1];

		for (int i = 1; i < leng1 + 1; i++) {
			arr1[i] = str1.charAt(i - 1);
		}
		for (int i = 1; i < leng2 + 1; i++) {
			arr2[i] = str2.charAt(i - 1);
		}

		// 최대 길이 dp 찾는 배열
		int[][] dp = new int[leng1 + 1][leng2 + 1];

		for (int i = 1; i < leng1 + 1; i++) {
			for (int j = 1; j < leng2 + 1; j++) {
				if (arr1[i] == arr2[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		// dp에 공통수열 최대 길이 저장 완료
		// 이제 역으로 그 공통수열의 내부에 무엇이 있는지 빼내봅시다.
		ArrayDeque<Character> q = new ArrayDeque<>();

		int a = leng1; // a 는 str1의 길이
		int b = leng2; // b 는 str2의 길이

		while (a > 0 && b > 0) {
			// a==b라면 공통수열이기 때문에
			// 스택에 추가 + a--, b--
			if (arr1[a] == arr2[b]) {
				q.add(arr1[a]);
				a--;
				b--;
			} else {
				if (dp[a - 1][b] > dp[a][b - 1])
					// a쪽이 더 크다면 a를 줄이고
					a--;
				else {
					// b쪽이 더 크다면 b를 줄임
					b--;
				}
			}

		}
		if (dp[leng1][leng2] == 0) {
			sb.append(0);
		} else {
			sb.append(dp[leng1][leng2]).append("\n");
			while (!q.isEmpty()) {
				sb.append(q.pollLast());
			}
		}
		System.out.println(sb.toString().trim());
	}
}