import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 문자열 두개가 주어졌을 때 두 문자열에 모두 포함된 공통 부분 문자열을 찾는 프로그램을 작성해라
		// s 의 부분 문자열 t란?
		// s에 t가 연속으로 나타나는 것을 말함
		// 공통수열 문제이긴 하지만 문장으로 받아야하기떄문에 아래처럼 풀었음

		String str1 = br.readLine();
		String str2 = br.readLine();

		int len1 = str1.length();
		int len2 = str2.length();

		int maxlen = 0;

		int[][] dp = new int[len1 + 1][len2 + 1];

		for (int i = 1; i < len1 + 1; i++) {
			for (int j = 1; j < len2 + 1; j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if (dp[i][j] > maxlen) {
						maxlen = dp[i][j];
					}
					
				} else {
					dp[i][j] =0; // 연속이 끊기게 된다면 0으로 초기화 해줘야 함
					
				}
			}
		}
		System.out.println(maxlen);
	}
}