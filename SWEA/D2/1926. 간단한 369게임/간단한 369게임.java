import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 정수의 개수 N

		StringBuilder sb = new StringBuilder();

		// 3, 6, 9 문제
		// 일의 자리부터 3,6,9 인지 확인한 후
		// 박수를 치는게 확정이 된다면 clap을 true로 만든후
		// 3,6,9가 포함된 개수 만큼 cnt를 1씩 늘림
		for (int i = 1; i <= N; i++) {
			String str = String.valueOf(i);
			int cnt = 0;
			boolean clap = false;
			for (int j = str.length() - 1; j >= 0; j--) {
				if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
					cnt++;
					clap = true;
				}
			}
			if (clap) {
				for (int c = 0; c < cnt; c++) {
					sb.append("-");
				}
			} else
				sb.append(i);

			sb.append(" ");
		}
		System.out.print(sb);
	}
}
