import java.util.*;
import java.io.*;

/**
 * 1786 찾기
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 두 개의 문자열 T, P가 있음
		// 문자열 P가 T 중간에 몇 번,어디서 나타나는지 출력하셈

		String T = br.readLine();
		String P = br.readLine();

		StringBuilder sb = new StringBuilder();

		// 맨 앞에 kmp의 cnt 값 삽입
		int ans = kmp(sb, P, T);
		sb.insert(0, "\n").insert(0, ans);

		System.out.println(sb.toString().trim());
	}

	private static int kmp(StringBuilder sb, String str1, String str2) {
		int len1 = str1.length();
		int[] pi = findPi(str1);
		int idx = 0;

		// cnt
		int cnt = 0;
		for (int i = 0; i < str2.length(); i++) {
			while (idx > 0 && str1.charAt(idx) != str2.charAt(i)) {
				idx = pi[idx - 1];
			}

			if (str1.charAt(idx) == str2.charAt(i)) {
				idx++;
			}

			if (idx == len1) {
				cnt++;
				sb.append(i - len1 + 2).append("\n");
				idx = pi[idx - 1];
			}

		}
		return cnt;
	}

	private static int[] findPi(String first) {
		int N = first.length();
		int idx = 0;
		int[] Pi = new int[N];

		for (int i = 1; i < N; i++) {
			while (idx > 0 && first.charAt(i) != first.charAt(idx)) {
				idx = Pi[idx - 1];
			}

			if (first.charAt(i) == first.charAt(idx)) {
				Pi[i] = ++idx;
			}
		}
		return Pi;
	}
}