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

		// 각 dp 배열 가로, 세로열에 추가
		// i-1을 함으로써 idx 맞춰줌
		for (int i = 1; i < leng1 + 1; i++) {
			arr1[i] = str1.charAt(i - 1);
		}

		for (int i = 1; i < leng2 + 1; i++) {
			arr2[i] = str2.charAt(i - 1);
		}

		// 0인 부분이 0으로 초기화 되어야하기 떄문에 +1 만큼의 크기로 만듬
		int[][] dp = new int[leng1 + 1][leng2 + 1];

		for (int i = 1; i < leng1 + 1; i++) {
			for (int j = 1; j < leng2 + 1; j++) {
				if (arr1[i] == arr2[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		System.out.println(dp[leng1][leng2]);
	}
}