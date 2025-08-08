import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 지정
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 필드 크기 M //파리채 크기 N
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int[][] arr = new int[M][M];

			for (int i = 0; i < M; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			// 정답
			int ans = 0 ;
			// 파리채 범위만큼 뺀 범위의 반복문
			for (int i = 0; i < M - N + 1; i++) {
				for (int j = 0; j < M - N + 1; j++) {
					int cnt = 0;
					for (int r = 0; r < N; r++) {
						for (int c = 0; c < N; c++) {
							cnt += arr[i + c][j + r];
						}
					}
					ans = Math.max(ans, cnt);
				}
			}
			System.out.println("#"+test+" "+ans);
		}
	}
}
