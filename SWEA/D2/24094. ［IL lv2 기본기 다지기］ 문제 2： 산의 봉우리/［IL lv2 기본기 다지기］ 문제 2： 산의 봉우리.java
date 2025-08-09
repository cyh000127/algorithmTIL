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

			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 델타 배열 선언
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, 1, -1 };
			// 봉우리 찾기
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					boolean isTrue = true;
					for (int d = 0; d < 4; d++) {
						int nr = dr[d] + i;
						int nc = dc[d] + j;
						if (nr < 0 || nr >= N || nc < 0 || nc >= N)
							continue;
						if (arr[i][j] <= arr[nr][nc]) {
							isTrue = false;
							break;
						}
					}
					if (isTrue)
						cnt++;
				}
			}
			System.out.println("#" + test + " " + cnt);
		}
	}
}
