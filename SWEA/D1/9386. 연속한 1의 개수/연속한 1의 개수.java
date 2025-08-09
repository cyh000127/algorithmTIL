import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {

			// 수열의 길이 N
			int N = Integer.parseInt(br.readLine());
			String n = br.readLine();
			char[] a = n.toCharArray();

			// cnt와 최대cnt 선언
			int cnt = 0;
			int maxCnt = 0;
			
			// a[i]가 1이 아니면 최대1 개수와 비교 후 cnt 초기화
			for (int i = 0; i < N; i++) {
				if (a[i] != '1') {
					maxCnt = Math.max(maxCnt, cnt);
					cnt = 0;
				} else
					cnt++;
			}
			
			// '1' 로 끝나는 경우 때문에 한번 더 계산
			maxCnt = Math.max(maxCnt, cnt);
			// 출력
			System.out.println("#" + test + " " + maxCnt);
		}
	}
}
