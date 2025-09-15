import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 백준
		// 1958. LCS 3

		// 3개의 문자열에 대한 LCS
		String A = br.readLine();
		String B = br.readLine();
		String C = br.readLine();

		int aLeng = A.length();
		int bLeng = B.length();
		int cLeng = C.length();

		char[] aarr = new char[aLeng + 1];
		char[] barr = new char[bLeng + 1];
		char[] carr = new char[cLeng + 1];

		for (int i = 1; i <= aLeng; i++) {
			aarr[i] = A.charAt(i - 1);
		}
		for (int i = 1; i <= bLeng; i++) {
			barr[i] = B.charAt(i - 1);
		}
		for (int i = 1; i <= cLeng; i++) {
			carr[i] = C.charAt(i - 1);
		}

		// 3차원 배열을 이용하여 LCS 구하기
		int[][][] dp = new int[aLeng + 1][bLeng + 1][cLeng + 1];

		for (int i = 1; i <= aLeng; i++) {
			for (int j = 1; j <= bLeng; j++) {
				for (int k = 1; k <= cLeng; k++) {
					if (aarr[i] == barr[j] && aarr[i] == carr[k]) {
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					} else {
						dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
					}

				}
			}
		}
		System.out.println(dp[aLeng][bLeng][cLeng]);
	}
}